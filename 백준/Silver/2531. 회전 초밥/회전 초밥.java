import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		// 초밥 가짓수의 최댓값
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < k; j++) {
				set.add(data[(i + j) % N]);
			}
			
			// 쿠폰 번호가 set에 포함이 안되어 있으면 추가
			if (!set.contains(c)) {
				set.add(c);
			}
			
			result = Math.max(result, set.size());
			set.clear();
		}
		
		System.out.print(result);
	}
}