import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 스위치 개수
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] switches = new int[N];
		for (int i = 0; i < N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		// 학생 수
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			// 남학생인 경우
			if (gender == 1) {
				for (int j = target - 1; j < N; j = j + target) {
					switches[j] = 1 - switches[j];
				}
			}
			// 여학생인 경우
			else {
				target -= 1;
				switches[target] = 1 - switches[target];
				int left = target - 1;
				int right = target + 1;
				
				while (true) {
					if (left < 0 || right >= N) {
						break;
					}
					if (switches[left] != switches[right]) {
						break;
					}
					switches[left] = 1 - switches[left];
					switches[right] = 1 - switches[right];
					left -= 1;
					right += 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(switches[i] + " ");
			if ((i + 1) % 20 == 0) {
				System.out.println();
			}
		}
	}
}