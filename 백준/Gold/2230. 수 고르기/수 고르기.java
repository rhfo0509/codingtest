import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int start = 0;
		int end = 0;
		
		int result = Integer.MAX_VALUE;
		
		while (end < N && start <= end) {
			int diff = arr[end] - arr[start];
			
			if (diff >= M) {
				result = Math.min(result, diff);
				start += 1;
			} else {
				end += 1;
			}
		}
		
		System.out.print(result);
	}

}