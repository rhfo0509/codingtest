import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[] weight;
    static List<List<Integer>> tree;
    static int[][] dp;
    static boolean[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        weight = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = weight[i];
        }
        dfs(1, 0);

        selected = new boolean[n + 1];
        selected[1] = dp[1][0] < dp[1][1];
        for (int next : tree.get(1)) {
            dfs2(next, 1, selected[1]);
        }

        System.out.println(Math.max(dp[1][0], dp[1][1]));
        for (int i = 1; i <= n; i++) {
            if (selected[i]) System.out.print(i + " ");
        }
    }
    static void dfs(int cur, int parent) {
        for (int next : tree.get(cur)) {
            if (parent == next) continue;
            dfs(next, cur);
            dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
            dp[cur][1] += dp[next][0];
        }
    }
    static void dfs2(int cur, int parent, boolean pSelected) {
        if (pSelected) {
            selected[cur] = false;
        } else {
            selected[cur] = dp[cur][0] < dp[cur][1];
        }

        for (int next : tree.get(cur)) {
            if (parent == next) continue;
            dfs2(next, cur, selected[cur]);
        }
    }
}