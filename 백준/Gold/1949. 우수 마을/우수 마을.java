import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static List<List<Integer>> tree;
    static int[] residents;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        residents = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            residents[i] = Integer.parseInt(st.nextToken());
        }

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        // dp[node][0] : node를 우수 마을로 선정하지 않을 때 subtree에서 우수 마을로 선정된 주민들의 총합
        // dp[node][1] : node를 우수 마을로 선정할 때 subtree에서 우수 마을로 선정된 주민들의 총합
        dp = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            dp[i][1] = residents[i];
        }
        dfs(1, 0);
        System.out.print(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int cur, int parent) {
        for (int next : tree.get(cur)) {
            if (next == parent) continue;
            dfs(next, cur);

            dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
            dp[cur][1] += dp[next][0];
        }
    }
}