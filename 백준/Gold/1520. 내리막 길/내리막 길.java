import java.io.*;
import java.util.*;
public class Main {
  static int M, N;
  static int[][] map, dp;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    map = new int[M][N];
    dp = new int[M][N];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        dp[i][j] = -1;
      }
    }
    dp[0][0] = dfs(0, 0);
    System.out.print(dp[0][0]);
  }
  static int dfs(int x, int y) {
    if (x == M - 1 && y == N - 1) {
      dp[M - 1][N - 1] = 1;
      return 1;
    }
    if (dp[x][y] >= 0) {
      return dp[x][y];
    }
    int cnt = 0;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
      if (map[x][y] <= map[nx][ny]) continue;
      cnt += dfs(nx, ny);
    }
    dp[x][y] = cnt;
    return cnt;
  }
}