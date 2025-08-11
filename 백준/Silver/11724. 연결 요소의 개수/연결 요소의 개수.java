import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<List<Integer>> graph;
	static boolean[] visited;

	public static void bfs(int x) {
		
		visited[x] = true;
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(x);
		
		while (!q.isEmpty()) {
			int px = q.poll();
			
			for (Integer nx : graph.get(px)) {
				if (!visited[nx]) {
					visited[nx] = true;
					q.offer(nx);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("Test3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		visited = new boolean[N + 1];
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				bfs(i);
				result++;
			}
		}
		System.out.print(result);
	}

}