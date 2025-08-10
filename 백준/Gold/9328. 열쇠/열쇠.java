import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int h, w, state, count;
	static char[][] maze;
	public static boolean check(int x, int y) {
		if (maze[x][y] == '*') return false;
		
			
		// 만약 열쇠가 있는 칸이라면
		if (maze[x][y] >= 'a' && maze[x][y] <= 'z') {
			state |= (1 << (maze[x][y] - 'a'));
		}
		// 만약 문이 있는 칸이라면
		else if (maze[x][y] >= 'A' && maze[x][y] <= 'Z') {
			char c = (maze[x][y] + "").toLowerCase().charAt(0);
			
			if (((state >> (c - 'a')) & 1) == 0) {
				return false;
			}
		}
		// 만약 문서가 있는 칸이라면
		else if (maze[x][y] == '$'){
			count++;
			maze[x][y] = '.';
		}
		return true;
	}
	
	// 칸 방문 여부
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static int bfs() {
		
		// 열쇠의 상태
		int prevState = state;
		
		Deque<int[]> q = new ArrayDeque<>();
		
		while (true) {
			visited = new boolean[h][w];
			
			// 빌딩 가장자리 벽이 아닌 곳 탐색
			for (int i = 0; i < w; i++) {
				if (check(0, i)) {
					q.offer(new int[] {0, i});
				}
				if (check(h - 1, i)) {
					q.offer(new int[] {h - 1, i});
				}
			}
			for (int i = 1; i < h - 1; i++) {
				if (check(i, 0)) {
					q.offer(new int[] {i, 0});
				}
				if (check(i, w - 1)) {
					q.offer(new int[] {i, w - 1});
				}
			}
			
			while (!q.isEmpty()) {
				int[] p = q.poll();
				int px = p[0];
				int py = p[1];
				
				for (int j = 0; j < 4; j++) {
					
					int nx = px + dx[j];
					int ny = py + dy[j];
					
					if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
					
					if (maze[nx][ny] == '*') continue;
					
					if (!visited[nx][ny]) {
						
						// 만약 열쇠가 있는 칸이라면
						if (maze[nx][ny] >= 'a' && maze[nx][ny] <= 'z') {
							state |= (1 << (maze[nx][ny] - 'a'));
						}
						// 만약 문이 있는 칸이라면
						else if (maze[nx][ny] >= 'A' && maze[nx][ny] <= 'Z') {
							char c = (maze[nx][ny] + "").toLowerCase().charAt(0);
							
							if (((state >> (c - 'a')) & 1) == 0) {
								continue;
							}
						}
						// 만약 문서가 있는 칸이라면
						else if (maze[nx][ny] == '$'){
							count++;
							maze[nx][ny] = '.';
						}
						
						// 방문 처리 -> 빈 칸일 때 포함
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
				
				
			}
			
			// 더 이상 열쇠 상태의 변화가 없을 때까지 반복
			if (prevState == state) break;
			prevState = state;
		}
		
		// 지금까지 훔친 문서 개수 반환
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			maze = new char[h][w];
			for (int i = 0; i < h; i++) {
				maze[i] = br.readLine().toCharArray();
			}
			
			state = 0;
			char[] keys = br.readLine().toCharArray();
			if (keys[0] != '0') {
				for (char key : keys) {
					state |= (1 << (key - 'a'));
				}
			}
			
			count = 0;
			System.out.println(bfs());
		}
	}

}