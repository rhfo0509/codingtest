import java.io.*;
import java.util.*;
public class Main {
    static int N, M, S;
    static List<List<Integer>> graph;
    static Deque<Integer> q;
    static int[] time, count;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            while (true) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 0) break;
                graph.get(i).add(n);
            }
        }
        M = Integer.parseInt(br.readLine());
        q = new ArrayDeque<>();
        visited = new boolean[N + 1];
        time = new int[N + 1];
        Arrays.fill(time, -1);
        count = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        // 최초유포자
        for (int i = 0; i < M; i++) {
            S = Integer.parseInt(st.nextToken());
            q.offer(S);
            visited[S] = true;
            time[S] = 0;
            count[S]++;
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    count[next]++;

                    if ((double) graph.get(next).size() / 2 <= count[next]) {
                        visited[next] = true;
                        time[next] = time[cur] + 1;
                        q.offer(next);
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(time[i] + " ");
        }
    }
}