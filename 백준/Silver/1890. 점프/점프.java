import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new long[N][N];
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                countPath(i, j);
            }
        }
        System.out.print(dp[N - 1][N - 1]);
    }
    static void countPath(int x, int y) {
        for (int i = x - 1; i >= Math.max(0, x - 9); i--) {
            if (board[i][y] + i == x) dp[x][y] += dp[i][y];
        }
        for (int j = y - 1; j >= Math.max(0, y - 9); j--) {
            if (board[x][j] + j == y) dp[x][y] += dp[x][j];
        }
    }
}
