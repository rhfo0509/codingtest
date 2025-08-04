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
	static int n, m;
	static List<List<Integer>> arr;
	static boolean[] visited, cycled;
	static int[] parent;
	
	public static int findParent(int n) {
		// 최상위 부모 노드라면
		if (parent[n] == n) {
			// 부모 노드의 인덱스 리턴
			return n;
		} 
		// 그렇지 않다면
		else {
			// 부모 노드의 최상위 부모 노드를 찾는다.
			return parent[n] = findParent(parent[n]);
		}
	}
	
	public static boolean union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if (findParent(a) == findParent(b)) {
			return false;
		} else {
			if (a < b) parent[b] = a;
			else parent[a] = b;
			return true;
		}
	}
	
	public static int bfs(int x) {
		visited[x] = true;
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(x);
		
		boolean isCycled = false;
		while (!q.isEmpty()) {
			int px = q.poll();
			for (int nx : arr.get(px)) {
				if (!isCycled && cycled[nx]) {
					isCycled = true;
				}
				if (!visited[nx]) {
					visited[nx] = true;
					q.offer(nx);
				}
			}
		}
		if (isCycled) return 0;
		return 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// n : 정점의 개수, m : 간선의 개수
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			if (n == 0 && m == 0) {
				break;
			}
			
			// 특정 노드의 부모 노드
			parent = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}
			
			arr = new ArrayList<List<Integer>>();
			for (int i = 0; i <= n; i++) {
				arr.add(new ArrayList<Integer>());
			}
			
			// 방문 여부
			visited = new boolean[n + 1];
			
			// 사이클 여부
			cycled = new boolean[n + 1];
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr.get(a).add(b);
				arr.get(b).add(a);
				
				if (!union(a, b)) {
					cycled[a] = true;
					cycled[b] = true;
				}
			}
			
			// 트리의 개수
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					count += bfs(i);
				}
			}
			if (count == 0) {
				System.out.printf("Case %d: No trees.\n", tc);
			} else if (count == 1) {
				System.out.printf("Case %d: There is one tree.\n", tc);
			} else {
				System.out.printf("Case %d: A forest of %d trees.\n", tc, count);
			}
			
			tc++;
		}
	}
}