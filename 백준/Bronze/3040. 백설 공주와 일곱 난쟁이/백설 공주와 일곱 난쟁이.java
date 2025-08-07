import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int[] arr;
	static List<Integer> cur;
	
	static void dfs(int start, int total, List<Integer> cur) {
        if (total > 100) return;
		if (cur.size() == 7 && total == 100) {
			for (Integer num : cur) {
				System.out.println(num);
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			cur.add(arr[i]);
			dfs(i + 1, total + arr[i], cur);
			cur.remove(cur.size() - 1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		cur = new ArrayList<Integer>();
		dfs(0, 0, cur);
	}

}