import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int newScore = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		if (N == 0) {
			System.out.print(1);
			return;
		}
		int[] scores = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
		}
		scores[N] = -1;
		
		int rank = -1;
		for (int i = 0; i < N + 1; i++) {
			if (newScore >= scores[i]) {
				rank = i + 1;
				int pos = i;
				for (int j = pos; j < N + 1; j++) {
					if (newScore > scores[j]) {
						pos = j + 1;
						break;
					}
				}
				
				if (pos > P) {
					rank = -1;
				}
				break;
			}
		}
		System.out.print(rank);
	}
}