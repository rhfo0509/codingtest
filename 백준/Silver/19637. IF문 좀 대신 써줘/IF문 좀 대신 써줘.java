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
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] power = new int[N];
        String[] title = new String[N];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	title[i] = st.nextToken();
        	power[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < M; i++) {
            int idx = binarySearch(power, Integer.parseInt(br.readLine()));
            sb.append(title[idx]).append("\n");
        }
        System.out.println(sb);
    }
}