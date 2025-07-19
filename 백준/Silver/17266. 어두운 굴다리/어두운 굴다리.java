import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] pos = new int[M];
		for (int i = 0; i < M; i++) {
			pos[i] = Integer.parseInt(st.nextToken());
		}
		
		// 처음 가로등의 높이는 0~pos[0] 사이의 길이로 설정
		int height = pos[0];
		
		for (int i = 0; i < M - 1; i++) {
			int dist = pos[i + 1] - pos[i];
			
			if (dist % 2 == 0) {
				height = Math.max(height, dist / 2);
			} else {
				height = Math.max(height, dist / 2 + 1);
			}
		}
		
		// pos[N-1]~N 사이의 길이도 고려
		height = Math.max(height, N - pos[M - 1]);
		
		System.out.print(height);
	}
}