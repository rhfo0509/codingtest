import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[][] A;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int maxCnt, maxNum, curNum;
	
	public static void dfs(int x, int y, int count) {
		// 매 dfs마다 최대로 방을 방문하고 있는지 검사
		if (count == maxCnt) {
			maxNum = Math.min(maxNum, curNum);
		}
		if (count > maxCnt) {
			maxCnt = count;
			maxNum = curNum;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			
			if (A[nx][ny] == A[x][y] + 1) dfs(nx, ny, count + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			A = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxCnt = 0;
			maxNum = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					curNum = A[i][j];
					dfs(i, j, 1);
				}
			}
			
			System.out.printf("#%d %d %d\n", tc, maxNum, maxCnt);
		}
	}

}
