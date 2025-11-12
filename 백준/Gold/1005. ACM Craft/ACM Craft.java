import java.io.*;
import java.util.*;

public class Main {

    static int N, K, target;
    static int[] elapsedTime, indegree, dp;
    static List<List<Integer>> graph;
    static Deque<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            elapsedTime = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                elapsedTime[i] = Integer.parseInt(st.nextToken());
            }

            indegree = new int[N + 1];
            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                indegree[Y] += 1;
                graph.get(X).add(Y);
            }

            target = Integer.parseInt(br.readLine());

            // dp[i] : i 번째 건물을 짓는 데 걸리는 최소 시간
            dp = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                dp[i] = elapsedTime[i];
            }

            q = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int next : graph.get(cur)) {
                    indegree[next]--;
                    dp[next] = Math.max(dp[cur] + elapsedTime[next], dp[next]);
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            System.out.println(dp[target]);
        }
    }
}