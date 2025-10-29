import java.io.*;
import java.util.*;

public class Main {

	static List<List<int[][]>> arr;
	static int[] order, dir;
	static boolean[] visited;
	// 5*5 사각형
	static int[][] square;
	// 완성된 미로
	static int[][][] maze;
	// 최소 이동 횟수
	static int minCount;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
        	arr.add(new ArrayList<>());
        }
        
        for (int z = 0; z < 5; z++) {
        	square = new int[5][5];
            for (int x = 0; x < 5; x++) {
            	st = new StringTokenizer(br.readLine());
            	for (int y = 0; y < 5; y++) {
            		square[x][y] = Integer.parseInt(st.nextToken());
            	}
            }
            
            // 기존 상태 저장
            arr.get(z).add(square);
            
            // 회전(총 3번)한 상태 저장
            for (int i = 0; i < 3; i++) {
            	turn();
            	arr.get(z).add(square);
            }
        }
        
        minCount = Integer.MAX_VALUE;
        order = new int[5];
        dir = new int[5];
        // 큐브를 쌓는 순서 정하기 (순열)
        visited = new boolean[5];
        dfs1(0);
        
        System.out.print(minCount == Integer.MAX_VALUE ? -1 : minCount - 1);
    }
    
   
    static void dfs1(int depth)
    {
    	if (depth == 5) {
    		// 5*5 정사각형 5개의 각각의 방향 정하기 (중복순열)
    		dfs2(0);
    		return;
    	}
    	
    	for (int i = 0; i < 5; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			order[depth] = i;
    			dfs1(depth + 1);
    			visited[i] = false;
    		}
    	}
    }
    
    static void dfs2(int depth) {
    	if (depth == 4) {
    		// 미로 완성시키기
    		maze = new int[5][5][5];
    		
			for (int z = 0; z < 5; z++) {
    			for (int x = 0; x < 5; x++) {
    				for (int y = 0; y < 5; y++) {
    					maze[z][x][y] = arr.get(order[z]).get(dir[z])[x][y];
    				}
    			}
    		}
    		// 미로의 양 끝 모서리가 둘다 갈 수 있는지 확인
    		// 갈 수 있다면 실제로 미로에서 사람 이동시키기
    		if (maze[0][0][0] == 1 && maze[4][4][4] == 1) bfs(0, 0, 0);
    		if (maze[0][0][4] == 1 && maze[4][4][0] == 1) bfs(0, 0, 4);
    		if (maze[0][4][0] == 1 && maze[4][0][4] == 1) bfs(0, 4, 0);
    		if (maze[0][4][4] == 1 && maze[4][0][0] == 1) bfs(0, 4, 4);
    		return;
    		
    	}
    	
    	for (int i = 0; i < 4; i++) {
    		dir[depth] = i;
    		dfs2(depth + 1);
    	}
    }
    
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    
    static class Point {
    	int z;
    	int x;
    	int y;
    	
    	Point(int z, int x, int y) {
    		this.z = z;
    		this.x = x;
    		this.y = y;
    	}
    }
    
    static void bfs(int z, int x, int y) {
    	int[][][] visited = new int[5][5][5];
    	Deque<Point> q = new ArrayDeque<>();
    	
    	visited[z][x][y] = 1;
    	q.offer(new Point(z, x, y));
    	
    	while (!q.isEmpty()) {
    		Point p = q.poll();
    		
    		if (p.z == 4 - z && p.x == 4 - x && p.y == 4 - y) {
    			minCount = Math.min(minCount, visited[p.z][p.x][p.y]);
    		}
    		for (int i = 0; i < 6; i++) {
    			int nz = p.z + dz[i];
    			int nx = p.x + dx[i];
    			int ny = p.y + dy[i];
    			
    			if (nz < 0 || nz >= 5 || nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nz][nx][ny] > 0 || maze[nz][nx][ny] == 0) {
    				continue;
    			}
    			
    			visited[nz][nx][ny] = visited[p.z][p.x][p.y] + 1;
    			q.add(new Point(nz, nx, ny));
    		}
    	}
    }
    
    static void turn() {
    	int[][] temp = new int[5][5];
    	
        for (int x = 0; x < 5; x++) {
        	for (int y = 0; y < 5; y++) {
        		temp[x][y] = square[y][5 - x - 1];
        	}
        }
        
        square = temp;
    }
}