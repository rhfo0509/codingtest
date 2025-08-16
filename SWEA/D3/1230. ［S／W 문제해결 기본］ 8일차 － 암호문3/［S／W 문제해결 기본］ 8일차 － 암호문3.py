import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int tc = 1;
		String input;
		while ((input = br.readLine()) != null) {
			int N = Integer.parseInt(input);
			
			ArrayList<Integer> arr = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				String cmd = st.nextToken();
				
				switch (cmd) {
				case "I":{
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for (int j = 0; j < y; j++) {
						temp.add(Integer.parseInt(st.nextToken()));
					}
					arr.addAll(x, temp);
					break;
				}
					
				case "D":{
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						arr.remove(x);
					}
					break;
				}
				case "A": {
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						arr.add(Integer.parseInt(st.nextToken()));
					}
					break;
				}
				default:
					break;
				}
				
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < 10; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
			
			tc++;
		}
		
	}

}