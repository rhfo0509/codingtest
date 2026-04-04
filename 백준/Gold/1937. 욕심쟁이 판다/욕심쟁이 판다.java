import java.io.*;
import java.util.*;
public class Main {
    static int n, mx;
    static int[][] forest, dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        forest = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > 0) continue;
                dp[i][j] = dfs(i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mx = Math.max(mx, dp[i][j]);
            }
        }
        System.out.print(mx);
    }
    static int dfs(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (forest[nx][ny] <= forest[x][y]) continue;
            if (dp[nx][ny] > 0) {
                cnt = Math.max(cnt, dp[nx][ny]);
            } else {
                cnt = Math.max(cnt, dfs(nx, ny));
            }
        }
        dp[x][y] = cnt + 1;
        return dp[x][y];
    }
}