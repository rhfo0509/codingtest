import java.io.*;
import java.util.*;

public class Main {
    static char[] s1, s2;
    static int[][] dp;
    static int r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
        r = s1.length + 1;
        c = s2.length + 1;
        // 1~r번째 수열 s1과 1~c번째 수열 s2로 만들 수 있는 최장 공통 부분 수열
        dp = new int[r][c];
        dp[1][1] = 1;
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.print(dp[r - 1][c - 1]);
    }
}