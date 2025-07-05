import java.util.*;
import java.io.*;

public class Main {
	public static int[] bfs(int n, List<List<Integer>> graph) {
		boolean[] visited = new boolean[n + 1];
		Deque<Integer> q = new ArrayDeque<>();
		int[] parent = new int[n + 1];
		
		q.offer(1);
		visited[1] = true;
		
		while (!q.isEmpty()) {
			int parentNode = q.poll();
			for (Integer node : graph.get(parentNode)) {
				if (!visited[node]) {
					visited[node] = true;
					parent[node] = parentNode;
					q.offer(node);
				}

			}
		}
		return parent;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<List<Integer>> graph = new ArrayList<List<Integer>>();
		
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		int[] result = bfs(n, graph);
		for (int i = 2; i <= n; i++) {
			System.out.println(result[i]);
		}
	}
}