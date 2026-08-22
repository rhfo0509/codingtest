class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[][] dp = new int[n][2];
        int answer = 0;
        // 1과 2로 나눈다. 이유) 0과 n-1을 같이 터는 경우는 존재하지 않기 때문
        // 1. 0에서 n-2까지 털 수 있는 경우
        dp[0][0] = 0;
        dp[0][1] = money[0];
        for (int i = 1; i < n - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + money[i];
        }
        answer = Math.max(dp[n - 2][0], dp[n - 2][1]);
        // 2. 1에서 n-1까지 털 수 있는 경우
        dp[1][0] = 0;
        dp[1][1] = money[1];
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + money[i];
        }
        answer = Math.max(answer, Math.max(dp[n - 1][0], dp[n - 1][1]));
        return answer;
    }
}