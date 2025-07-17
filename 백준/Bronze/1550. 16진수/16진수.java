import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String numStr = br.readLine();
		int num = Integer.parseInt(numStr, 16);
		System.out.println(num);
	}
}