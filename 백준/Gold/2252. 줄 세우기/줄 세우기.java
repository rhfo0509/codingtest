import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<Integer>> graph;
    static int[] indegree;
    static Deque<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            indegree[B] += 1;
        }

        // 진입 차수가 0인 정점을 큐에 넣는다.
        q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // 큐가 빌 때까지 반복한다.
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (Integer next : graph.get(node)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}