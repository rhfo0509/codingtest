import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Main {
	
	static int n, m;
	static List<List<Integer>> arr;
	static int[] visited;
	
	public static void bfs(int x) {
		visited = new int[n + 1];
		Arrays.fill(visited, -1);
		visited[x] = 0;
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.add(x);
		
		while (!q.isEmpty()) {
			int px = q.poll();
			
			for (Integer nx : arr.get(px)) {
				if (visited[nx] == -1) {
					visited[nx] = visited[px] + 1;
					q.offer(nx);
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		arr = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			String[] friends = br.readLine().split(" ");
			int a = Integer.parseInt(friends[0]);
			int b = Integer.parseInt(friends[1]);
			
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		bfs(1);
		
		int result = 0;
		for (int v : visited) {
			if (v >= 1 && v <= 2) {
				result += 1;
			}
		}
		System.out.println(result);
	}

}