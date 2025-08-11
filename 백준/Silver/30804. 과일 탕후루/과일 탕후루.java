import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] data = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	data[i] = Integer.parseInt(st.nextToken());
        }

        // fruits[i] : i번 과일의 개수 in 탕후루
        int[] fruits = new int[10];
        
        int start = 0;
        int end = 0;
        fruits[data[0]] += 1;
        
        // count : 과일 종류 개수 in 탕후루
        int count = 1;
        
        // 과일의 개수가 가장 많은 탕후루의 과일 개수
        int result = 1;
        
        for (start = 0; start < N; start++) {
        	
        	while (end < N && count <= 2) {
        		
        		end++;
        		if (end == N) break;
        		if (fruits[data[end]] == 0) {
        			count++;
        		}
    			fruits[data[end]] += 1;
    			
        	}
        	
        	result = Math.max(result, end - start);
        	if (end == N) break;
        	
        	if (fruits[data[start]] == 1) {
        		count--;
        	}
        	fruits[data[start]] -= 1;
        }
        
        System.out.print(result);
    }
}