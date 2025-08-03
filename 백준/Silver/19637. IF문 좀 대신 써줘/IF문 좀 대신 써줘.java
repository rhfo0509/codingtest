import java.io.*;
import java.util.*;

public class Main {
	public static int binarySearch(int[] power, int target) {
		
		int start = 0;
		int end = power.length;
		int mid;
		int result = end - 1;
		
		while (start <= end) {
			mid = (start + end) / 2;
			
			if (power[mid] >= target) {
				result = mid;
				// 파라메트릭 서치
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return result;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sb = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sb.nextToken());
        int M = Integer.parseInt(sb.nextToken());
        
        int[] power = new int[N];
        String[] title = new String[N];
        for (int i = 0; i < N; i++) {
        	sb = new StringTokenizer(br.readLine());
        	title[i] = sb.nextToken();
        	power[i] = Integer.parseInt(sb.nextToken());
        }
        
        for (int i = 0; i < M; i++) {
            int idx = binarySearch(power, Integer.parseInt(br.readLine()));
            System.out.println(title[idx]);
        }
    }
}