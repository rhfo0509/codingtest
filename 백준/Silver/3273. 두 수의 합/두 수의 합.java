import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int target = Integer.parseInt(br.readLine());
		
		// 정렬
		// 1 2 3 5 7 9 10 11 12
		Arrays.sort(arr);
		
		int startIndex = 0;
		int endIndex = n - 1;
		
		int result = 0;
		
		while (startIndex != endIndex) {
			int temp = arr[startIndex] + arr[endIndex];
			
			if (temp == target) {
				result += 1;
				endIndex--;
			} else if (temp < target) {
				startIndex++;
			} else {
				endIndex--;
			}
		}
		
		System.out.print(result);
	}

}