import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String numStr = br.readLine();
		int num = 0;
		for (int i = 0; i < numStr.length(); i++) {
			num += Integer.parseInt(numStr.charAt(i) + "", 16) * Math.pow(16, numStr.length() - i - 1);
		}
		System.out.println(num);
	}
}