import java.io.*;
import java.util.*;
public class Main {
	static int[] arr, selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		selected = new int[7];
		dfs(0, 0, 0);
	}
	static void dfs(int depth, int sum, int start) {
		if (sum > 100) return;
		if (depth == 7) {
			if (sum != 100) return;
			for (int height : selected) {
				System.out.println(height);
			}
			System.exit(0);

		}
		for (int i = start; i < 9; i++) {
			selected[depth] = arr[i];
			dfs(depth + 1, sum + arr[i], i + 1);
		}
	}
}