import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	static int[][] maze;
	static boolean[][] visited;
	static int sx, sy, ex, ey;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static int result;
	
	static void dfs(int x, int y) {
		
		if (maze[x][y] == 3) {
			result = 1;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100) continue;
			
			if (maze[nx][ny] == 1) continue;
			
			if (visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			
			maze = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String input = br.readLine();
				for (int j = 0; j < 100; j++) {
					maze[i][j] = input.charAt(j) - '0';
					
					if (maze[i][j] == 2) {
						sx = i;
						sy = j;
					}
					
					else if (maze[i][j] == 3) {
						ex = i;
						ey = j;
					}
				}
			}
			
			visited = new boolean[100][100];
			result = 0;
			dfs(sx, sy);
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}

}