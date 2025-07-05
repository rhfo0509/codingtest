import java.util.*;
import java.io.*;

public class Main {
	// 좌표 클래스
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static int bfs(int x, int y, int r, int c, char[][] data) {
		int count = 0;
		boolean[][] visited = new boolean[r][c];
		Deque<Point> q = new ArrayDeque<Point>();
		
		q.add(new Point(x, y));
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			Point node = q.poll();
			int px = node.x;
			int py = node.y;
			if (data[px][py] == 'P') {
				count++;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				if (nx < 0 || nx >= r || ny < 0 || ny >= c || data[nx][ny] == 'X' || visited[nx][ny]) {
					continue;
				}
				q.add(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}
		
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] data = new char[n][m];
		for (int i = 0; i < n; i++) {
			String rowData = br.readLine();
			for (int j = 0; j < m; j++) {
				data[i][j] = rowData.charAt(j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (data[i][j] == 'I') {
					int result = bfs(i, j, n, m, data);
					if (result == 0) {
						System.out.print("TT");
					} else {
						System.out.print(result);
					}
				}
			}
		}
	}
}