import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[][] data = new String[N][N];
		
		// 심장 좌표
		int hx = -1;
		int hy = -1;
		
		// 왼쪽 다리 시작 좌표
		int llx = -1;
		int lly = -1;
		
		// 오른쪽 다리 시작 좌표
		int rlx = -1;
		int rly = -1;
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				data[i][j] = input.charAt(j) + "";
			}
		}
		
		// 머리의 좌표 기록 -> 심장의 좌표
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (data[i][j].equals("*")) {
					hx = i + 1;
					hy = j;
					break;
				}
			}
			if (hx != -1 && hy != -1) {
				break;
			}
		}
		
		// 왼쪽 팔
		int left_arm = 0;
		for (int i = hy - 1; i >= 0; i--) {
			if (data[hx][i].equals("_")) {
				break;
			}
			left_arm++;
		}
		// 오른쪽 팔
		int right_arm = 0;
		for (int i = hy + 1; i < N; i++) {
			if (data[hx][i].equals("_")) {
				break;
			}
			right_arm++;
		}
		// 허리
		int waist = 0;
		for (int i = hx + 1; i < N; i++) {
			if (data[i][hy].equals("_")) {
				llx = i;
				lly = hy - 1;
				rlx = i;
				rly = hy + 1;
				break;
			}
			waist++;
		}
		// 왼쪽 다리
		int left_leg = 0;
		for (int i = llx; i < N; i++) {
			if (data[i][lly].equals("_")) {
				break;
			}
			left_leg++;
		}
		// 오른쪽 다리
		int right_leg = 0;
		for (int i = rlx; i < N; i++) {
			if (data[i][rly].equals("_")) {
				break;
			}
			right_leg++;
		}
		System.out.printf("%d %d\n", hx + 1, hy + 1);
		System.out.printf("%d %d %d %d %d", left_arm, right_arm, waist, left_leg, right_leg);
	}
}