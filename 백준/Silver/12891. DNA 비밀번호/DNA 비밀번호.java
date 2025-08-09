import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int S, P;
	static char[] dna;
	static int[] target, cur;
	
	public static void add(char c) {
		if (c == 'A') cur[0]++;
		else if (c == 'C') cur[1]++;
		else if (c == 'G') cur[2]++;
		else cur[3]++;
	}
	
	public static void remove(char c) {
		if (c == 'A') cur[0]--;
		else if (c == 'C') cur[1]--;
		else if (c == 'G') cur[2]--;
		else cur[3]--;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		dna = br.readLine().toCharArray();
		
		// 순서대로 A, C, G, T
		target = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		
		// 순서대로 A, C, G, T
		cur = new int[4];
		for (int i = 0; i < P; i++) {	
			char c = dna[i];
			add(c);
		}
		

		int result = 0;
		for (int i = P; i <= S; i++) {
			
			boolean valid = true;
			for (int j = 0; j < 4; j++) {
				if (cur[j] < target[j]) {
					valid = false;
					break;
				}
			}
			
			if (valid) {
				result++;
			}
			
			if (i == S) {
				break;
			}
			
			char newC = dna[i];
			add(newC);
			char oldC = dna[i - P];
			remove(oldC);
		}
		
		System.out.print(result);
	}

}