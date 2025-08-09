import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, m;
	static List<List<Integer>> badList;
	static boolean[] selected;
	static int result;
	
	public static void subset(int depth) {
		
		
		if (depth == n + 1) {
			result++;
			return;
		} else {
			
			selected[depth] = false;
			subset(depth + 1);
			
			for (int i = 1; i < depth; i++) {
				if (selected[i]) {
					for (int badPartner : badList.get(i)) {
						if (badPartner == depth) return;
					}
				}
			}
			
			selected[depth] = true;
			subset(depth + 1);
			
			
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			badList = new ArrayList<>();
			
			for (int i = 0; i <= n; i++) {
				badList.add(new ArrayList<>());
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				badList.get(a).add(b);
				badList.get(b).add(a);
			}
			
			selected = new boolean[n + 1];
			result = 0;
			subset(1);
			
			System.out.printf("#%d %d\n", tc, result);
		}
		
	}

}