import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> li = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			li.add(i - Integer.parseInt(st.nextToken()), i + 1);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(li.get(i) + " ");
		}
	}
}