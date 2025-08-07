import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<List<Integer>> arr;
	static boolean[] visited;
	static int[] count;
	static int maxCount;
	
	public static void bfs(int x) {
		visited = new boolean[N + 1];
		visited[x] = true;
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.offer(x);
		
		count[x] = 1;
		while (!q.isEmpty()) {
			int px = q.poll();
			
			for (Integer nx : arr.get(px)) {
				if (!visited[nx]) {
					visited[nx] = true;
					q.offer(nx);
					count[x]++;
				}
			}
		}
		
		maxCount = Math.max(maxCount, count[x]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<List<Integer>>();
		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr.get(b).add(a);
		}
		
		count = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (maxCount == count[i]) {
				sb.append(i).append(" ");
			}
		}
		System.out.print(sb);
	}

}