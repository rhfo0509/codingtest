import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m][n];
        for (int[] puddle : puddles) {
            int pm = puddle[0] - 1;
            int pn = puddle[1] - 1;
            // 물에 잠긴 지역은 도달 불가
            dp[pm][pn] = -1;
        }
        for (int i = 0; i < m; i++) {
            if (dp[i][0] == -1) break;
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (dp[0][i] == -1) break;
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] == -1) continue;
                if (dp[i - 1][j] != -1) dp[i][j] += dp[i - 1][j];
                dp[i][j] %= 1_000_000_007;
                if (dp[i][j - 1] != -1) dp[i][j] += dp[i][j - 1];
                dp[i][j] %= 1_000_000_007;
            }
        }
        int answer = dp[m - 1][n - 1];
        return answer;
    }
}