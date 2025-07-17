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
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < k; i++) {
//			if (map.containsKey(data[i])) {
//				map.put(data[i], map.get(data[i]) + 1);
//			} else {
//				map.put(data[i], 1);
//			}
			
			map.put(data[i], map.getOrDefault(data[i], 0) + 1);
			
//			map.merge(data[i], 1, Integer::sum);
		}
		
		// 초밥 가짓수의 최댓값
		int result = map.size();
		
		if (!map.containsKey(c)) {
			result += 1;
		}
		
		int from = 0;
		int to = k - 1;
		for (int i = 0; i < N; i++) {
			
			map.put(data[from], map.get(data[from]) - 1);
			if (map.get(data[from]) == 0) {
				map.remove(data[from]);
			}
			from += 1;
			to = (to + 1) % N;
			map.put(data[to], map.getOrDefault(data[to], 0) + 1);
			
			int count = map.size();
			
			if (!map.containsKey(c)) {
				count += 1;
			}
			
			result = Math.max(result, count);
		}
		
		System.out.print(result);
	}
}