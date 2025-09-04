import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, L;
	// {맛에 대한 점수, 칼로리}
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			// dp[n][l]: 재료의 수가 n이고, 제한 칼로리가 l일때 가치합의 최댓값
			dp = new int[N + 1][L + 1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				for (int j = 1; j <= L; j++) {
					// 1. 해당 재료를 선택하지 않는 경우
					dp[i][j] = dp[i - 1][j];
					if (j - k >= 0) {
						// 2. 해당 재료를 선택하는 경우
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k] + t);
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, dp[N][L]);
		}
	}

}