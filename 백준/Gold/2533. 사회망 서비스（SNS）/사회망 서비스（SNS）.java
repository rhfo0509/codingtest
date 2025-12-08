import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static List<List<Integer>> tree;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        // dp[node][0] : 해당 node가 얼리 어답터가 아닐때 서브트리에서의 얼리 어답터의 수
        // dp[node][1] : 해당 node가 얼리 어답터일 때 서브트리에서의 얼리 어답터의 수
        dp = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            dp[i][1] = 1;
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        dfs(1, 0);
        System.out.print(Math.min(dp[1][0], dp[1][1]));
    }
    static void dfs(int cur, int parent) {
        for (int next : tree.get(cur)) {
            if (next == parent) continue;
            dfs(next, cur);
            dp[cur][0] += dp[next][1];
            dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}
