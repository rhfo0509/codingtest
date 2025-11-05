import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] A, B, C, D, AB, CD;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		B = new int[n];
		C = new int[n];
		D = new int[n];
		
		AB = new int[n * n];
		CD = new int[n * n];
		
		long result = 0L;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			A[i] = a;
			B[i] = b;
			C[i] = c;
			D[i] = d;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				AB[i * n + j] = A[i] + B[j];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				CD[i * n + j] = C[i] + D[j];
			}
		}
		
		Arrays.sort(CD);
		
		for (int i = 0; i < n * n; i++) {
			int s = lowerBound(i);
			int e = upperBound(i);
			
			result += (e - s);
		}
		
		System.out.print(result);
	}

	static int lowerBound(int i) {
		int start = 0;
		int end = n * n;
		
		while (start < end) {
			int mid = (start + end) / 2;
			
			if (AB[i] + CD[mid] >= 0) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return end;
	}
	
	static int upperBound(int i) {
		int start = 0;
		int end = n * n;
		
		while (start < end) {
			int mid = (start + end) / 2;
			
			if (AB[i] + CD[mid] > 0) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return end;
	}
}
