import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// two-pointer
		int start = 0;
		int end = 0;
		
		// 현재 부분합
		int sum = arr[start];
		
		// S 이상인 부분합 중 가장 짧은 것의 길이
		int result = Integer.MAX_VALUE;
		
		for (start = 0; start < N; start++) {
			while (end < N && sum < S) {
				end++;
				if (end == N) break;
				sum += arr[end];
			}
			if (end == N) break;
			result = Math.min(result, end-start+1);
			sum -= arr[start];
		}
		
		System.out.print(result == Integer.MAX_VALUE ? 0 : result);
	}

}
