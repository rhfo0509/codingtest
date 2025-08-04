import java.io.*;
import java.util.*;

public class Main {
	public static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static int bfs(int x, int y, int L, int R, boolean[][] visited, int[][] arr, int n) {
		// 인구 이동 발생 횟수
		int moveCount = 0;
		
		visited[x][y] = true;
		
		// 국경선 공유하는 나라들의 인구수 총합
		int total = arr[x][y];
		
		// 국경선 공유하는 나라들의 좌표
		List<Point> pos = new ArrayList<>();
		pos.add(new Point(x, y));
		
		Deque<Point> q = new ArrayDeque<Point>();
		q.offer(new Point(x, y));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			int px = p.x;
			int py = p.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				
				if (
					nx < n && nx >= 0
					&& ny < n && ny >= 0
					&& Math.abs(arr[px][py] - arr[nx][ny]) >= L 
					&& Math.abs(arr[px][py] - arr[nx][ny]) <= R
					&& !visited[nx][ny]
				) {
					moveCount++;
					visited[nx][ny] = true;
					q.offer(new Point(nx, ny));
					total += arr[nx][ny];
					pos.add(new Point(nx, ny));
				}
			}
			
		}
		
		for (Point p : pos) {
			arr[p.x][p.y] = total / pos.size();
		}
		
		return moveCount;
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int result = 0;
        while (true) {
        	int count = 0;
        	boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
            		if (!visited[i][j]) {
            			count += bfs(i, j, L, R, visited, arr, N);
            		}
            	}
            }
            if (count == 0) {
            	break;
            }
            result++;
        }
        
        System.out.print(result);
    }
}