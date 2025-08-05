import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[][] arr;
	
	
	public static void preOrder(int i) {
		System.out.print((char) (i + 'A'));
		if (arr[i][0] != -1) preOrder(arr[i][0]);
		if (arr[i][1] != -1) preOrder(arr[i][1]);
		
	}
	
	public static void inOrder(int i) {
		if (arr[i][0] != -1) inOrder(arr[i][0]);
		System.out.print((char) (i + 'A'));
		if (arr[i][1] != -1) inOrder(arr[i][1]);
	}
	
	public static void postOrder(int i) {
		if (arr[i][0] != -1) postOrder(arr[i][0]);
		if (arr[i][1] != -1) postOrder(arr[i][1]);
		System.out.print((char) (i + 'A'));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], -1);
		}
		
		for (int i = 0; i < N; i++) {
			String[] data = br.readLine().split(" ");
			int root = data[0].charAt(0) - 'A';
			
			if (!data[1].equals(".")) {
				arr[root][0] = data[1].charAt(0) - 'A';
			}
			if (!data[2].equals(".")) {
				arr[root][1] = data[2].charAt(0) - 'A';
			}	
		}
		
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
	}

}
