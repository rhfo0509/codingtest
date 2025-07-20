import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = -1;
		int r = -1;
		int c = -1;
		for (int i = 1; i <= 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num > max) {
					max = num;
					r = i;
					c = j;
				}
			}
		}
		System.out.println(max);
		System.out.print(r + " " + c);
	}
}