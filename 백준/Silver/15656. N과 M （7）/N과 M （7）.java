import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Integer> cur;
	static int[] arr;
//	static boolean[] visited;
	static StringBuilder sb;
	
	public static void dfs(int length) {
		if (length == M) {
			for (Integer i : cur) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			cur.add(arr[i]);
			dfs(length + 1);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		cur = new ArrayList<>();
//		visited = new boolean[N];
		sb = new StringBuilder();
		
		dfs(0);
		System.out.println(sb);
	}

}