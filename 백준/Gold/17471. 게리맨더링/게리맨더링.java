import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] population;
    static List<List<Integer>> graph;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        population = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        result = Integer.MAX_VALUE;
        subset(1, new boolean[n + 1]);
        if (result == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(result);
        }
    }
    static void subset(int depth, boolean[] selected) {
        if (depth > n) {
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (selected[i]) {
                    A.add(i);
                } else {
                    B.add(i);
                }
            }
            if (A.isEmpty() || B.isEmpty()) return;
            bfs(A, B);
            return;
        }

        selected[depth] = true;
        subset(depth + 1, selected);
        selected[depth] = false;
        subset(depth + 1, selected);
    }

    static void bfs(List<Integer> A, List<Integer> B) {
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> q = new ArrayDeque<>();

        // A
        visited[A.get(0)] = true;
        q.offer(A.get(0));
        int ACount = 1;
        int APopulation = population[A.get(0)];

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer next : graph.get(cur)) {
                if (!visited[next] && A.contains(next)) {
                    visited[next] = true;
                    q.offer(next);
                    ACount++;
                    APopulation += population[next];
                }
            }
        }

        if (ACount != A.size()) return;

        visited = new boolean[n + 1];
        // B
        visited[B.get(0)] = true;
        q.offer(B.get(0));
        int BCount = 1;
        int BPopulation = population[B.get(0)];

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer next : graph.get(cur)) {
                if (!visited[next] && B.contains(next)) {
                    visited[next] = true;
                    q.offer(next);
                    BCount++;
                    BPopulation += population[next];
                }
            }
        }

        if (BCount != B.size()) return;

        // 모든 조건을 충족한다면
        result = Math.min(result, Math.abs(APopulation - BPopulation));
    }
}
