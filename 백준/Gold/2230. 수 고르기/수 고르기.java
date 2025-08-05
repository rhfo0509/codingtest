import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int result = Integer.MAX_VALUE;
	static int[] arr;
	
	public static void binarySearch(int idx, int target) {
		// 이분탐색
		int start = idx;
		int end = N - 1;
		int mid;
		
		while (start <= end) {
			mid = (start + end) / 2;
			int diff = arr[mid] - target;
			if (diff >= M) {
				result = Math.min(result, diff);
				// 더 차이가 작은 값이 있는지 탐색
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			int a = arr[i];
			binarySearch(i + 1, a);
		}
		
		System.out.print(result);
	}

}
