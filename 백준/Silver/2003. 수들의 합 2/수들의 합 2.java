import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        
        int start = 0;
        int end = 0;
        
        int cur = arr[end];
        
        // 수들의 합이 M이 되는 가짓수
        int result = 0;
        
        // end pointer가 배열을 벗어남 -> 더 이상 M보다 큰 경우가 존재할 수 없음 -> break
        while (true) {
        	if (cur >= M) {
        		if (cur == M) result++;
        		if (start == end) {
        			end += 1;
        			if (end == N) break;
        			cur += arr[end];
        		}
        		cur -= arr[start];
        		start += 1;
        	} else {
        		end += 1;
        		if (end == N) break;
        		cur += arr[end];
        	}
        }
        System.out.print(result);
    }
}