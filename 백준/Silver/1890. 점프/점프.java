import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new long[N][N];
        dp[0][0] = 1;
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) continue;
                calculate(i, j);
            }
        }
        calculate(N - 1, N - 1);
        System.out.print(dp[N - 1][N - 1]);
    }
    static void calculate(int x, int y) {
        for (int i = 1; i <= 9; i++) {
            if (x - i >= 0 && board[x - i][y] == i) {
                dp[x][y] += dp[x - i][y];
            }
            if (y - i >= 0 && board[x][y - i] == i) {
                dp[x][y] += dp[x][y - i];
            }
        }
    }
}