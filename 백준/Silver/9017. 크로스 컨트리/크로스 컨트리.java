import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			HashMap<Integer, Integer> map = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int team = Integer.parseInt(st.nextToken());
				arr[i] = team;
				map.put(team, map.getOrDefault(team, 0) + 1);
			}
			
			// arr2[team][0] : 각 팀의 네 번째 선수까지 점수의 합
			// arr2[team][1] : 각 팀의 다섯 번째 선수의 점수
			// arr2[team][2] : 현재까지 저장한 선수 카운트
			int[][] arr2 = new int[201][3];
			int cur = 1;
			for (int i = 0; i < N; i++) {
				int team = arr[i];
				if (map.get(team) == 6) {
					arr2[team][2] += 1;
					if (arr2[team][2] <= 4) {
						arr2[team][0] += cur;
					} else if (arr2[team][2] == 5) {
						arr2[team][1] = cur;
					}
					cur++;
				}
			}
			
			int winner = 0;
			for (int i = 1; i <= 200; i++) {
				if (arr2[i][2] < 6) {
					continue;
				}
				if (winner == 0 && arr2[i][2] == 6) {
					winner = i;
					continue;
				}
				if ((arr2[winner][0] > arr2[i][0]) || 
					(arr2[winner][0] == arr2[i][0] && arr2[winner][1] > arr2[i][1])) {
					winner = i;
				}
			}
			System.out.println(winner);
		}
	}
}