import java.util.*;
import java.io.*;

public class Main {
	
	public static void bfs(int x, int n, List<List<Integer>> graph) {
		boolean[] visited = new boolean[n];
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.add(x);
//		visited[x] = true;
		
		int[] result = new int[n];
		
		while (!q.isEmpty()) {
			int px = q.poll();
			for(Integer nx : graph.get(px)) {
				if (visited[nx]) {
					continue;
				}
				result[nx] = 1;
				q.add(nx);
				visited[nx] = true;
			}
		}
		
		for (int flag : result) {
			System.out.print(flag + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n; i++) {
			List<Integer> row = graph.get(i);
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					row.add(j);
				}
			}
		}
		
		int[][] result = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			bfs(i, n, graph);
		}
	}
}