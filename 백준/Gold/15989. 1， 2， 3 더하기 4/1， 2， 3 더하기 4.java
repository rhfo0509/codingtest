import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		dp = new int[10001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for (int i = 4; i <= 10000; i++) {
			// case 1. 1로만 구성된 경우
			dp[i] += 1;
			
			// case 2. 1과 2로만 구성된 경우
			dp[i] += (i - 2) / 2 + 1;
			
			// case 3. 1, 2, 3이 "모두" 포함된 경우
			dp[i] += dp[i - 3];
		}
		
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}

}
