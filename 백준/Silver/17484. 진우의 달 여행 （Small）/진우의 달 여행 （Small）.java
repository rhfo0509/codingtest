import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기값 설정
		// dp[x][y][0] : 해당 위치에 (↘) 방향으로 도달했을 때 최소 연료
		// dp[x][y][1] : 해당 위치에 (↓) 방향으로 도달했을 때 최소 연료
		// dp[x][y][2] : 해당 위치에 (↙) 방향으로 도달했을 때 최소 연료
		int[][][] dp = new int[N][M][3];
		for (int i = 0; i < M; i++) {
			dp[0][i][0] = arr[0][i];
			dp[0][i][1] = arr[0][i];
			dp[0][i][2] = arr[0][i];
		}
		
		for (int i = 1; i < N; i++) {
			// j = 0
			dp[i][0][0] = Integer.MAX_VALUE; // 불가능한 경로
			dp[i][0][1] = dp[i-1][0][2] + arr[i][0];
			dp[i][0][2] = Math.min(dp[i-1][1][0], dp[i-1][1][1]) + arr[i][0];
			for (int j = 1; j < M - 1; j++) {
				dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
				dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
				dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + arr[i][j];
			}
			dp[i][M-1][0] = Math.min(dp[i-1][M-2][1], dp[i-1][M-2][2]) + arr[i][M-1];
			dp[i][M-1][1] = dp[i-1][M-1][0] + arr[i][M-1];
			dp[i][M-1][2] = Integer.MAX_VALUE; // 불가능한 경로
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 3; j++) {
				if (result > dp[N-1][i][j]) {
					result = dp[N-1][i][j];
				}
			}
		}
		System.out.println(result);
	}
}