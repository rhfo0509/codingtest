import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		
		HashSet<String> set = new HashSet<String>();
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		if (game.equals("Y")) {
			System.out.print(set.size());
		} else if (game.equals("F")) {
			System.out.print(set.size() / 2);
		} else {
			System.out.print(set.size() / 3);
		}
	}
}