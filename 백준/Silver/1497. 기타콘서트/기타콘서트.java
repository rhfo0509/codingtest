import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	// 상태를 저장할 배열 (비트마스킹)
	static long[] states;
	// 선택 여부를 저장할 배열
	static boolean[] selected;
	// 필요한 최소 기타 수
	static int minCount;
	// 가장 큰 상태
	static long maxState;
	
	public static void subset(int count) {
		if (count == N) {
			long curState = 0;
			int curCount = 0;
			
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					curState |= states[i];
					curCount++;
				}
			}
			
			if (curState == maxState) {
				minCount = Math.min(minCount, curCount);
			}
			return;
		} else {
			selected[count] = true;
			subset(count + 1);
			
			selected[count] = false;
			subset(count + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 기타의 개수
		M = Integer.parseInt(st.nextToken()); // 곡의 개수
		
		states = new long[N];
		maxState = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); // 이름 건너뛰기
			String data = st.nextToken();
			for (int j = 0; j < M; j++) {
				if (data.charAt(j) == 'Y') {
					states[i] |= (1L << (M - 1 - j));
				}
			}
			maxState |= states[i];
		}
		
		selected = new boolean[N];
		minCount = N;
		subset(0);
		
		System.out.println(maxState == 0 ? -1 : minCount);
	}

}