import java.util.*;
import java.io.*;

public class Main {
	public static int bfs(int n, int start, int target, List<List<Integer>> data) {
		int[] visited = new int[n + 1];
		Deque<Integer> q = new ArrayDeque<>();
		
		q.offer(start);
		visited[start] = 1;
		
		while (!q.isEmpty()) {
			int px = q.poll();
			if (px == target) {
				return visited[px] - 1;
			}
			for (Integer nx : data.get(px)) {
				if (visited[nx] == 0) {
					visited[nx] = visited[px] + 1;
					q.offer(nx);
				}

			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<List<Integer>> al = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			al.add(new ArrayList<>());
		}
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			al.get(x).add(y);
			al.get(y).add(x);
		}
		
		int result = bfs(n, a, b, al);
		System.out.print(result);
	}
}