import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// 비트마스킹 기법으로 풀어보기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 비트마스킹을 적용할 상태 변수
		int state = 0;
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			String cmd = input[0];
			
			switch (cmd) {
			case "add": {
				int n = Integer.parseInt(input[1]);
				state |= (1 << (n - 1));
				break;
			}
			case "remove": {
				int n = Integer.parseInt(input[1]);
				state &= ~(1 << (n - 1));
				break;
			}
			case "check": {
				int n = Integer.parseInt(input[1]);
				sb.append((state >> (n - 1)) & 1).append("\n");
				break;
			}
			case "toggle": {
				int n = Integer.parseInt(input[1]);
				state ^= (1 << (n - 1));
			}
				break;
			case "all":
				state = 0xffffffff;
				break;
			case "empty":
				state = 0;
				break;
			default:
				break;
			}
		}
		
		System.out.print(sb);
	}

}