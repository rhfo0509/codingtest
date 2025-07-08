import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		String B = br.readLine();
		
		int result = 0;
		for (int i = 0; i < 3; i++) {
			int sum = A * (B.charAt(2 - i) - '0');
			System.out.println(sum);
			result += sum * Math.pow(10, i);
		}
		System.out.print(result);
	}
}