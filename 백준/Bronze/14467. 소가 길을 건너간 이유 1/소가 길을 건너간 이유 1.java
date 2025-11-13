import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[11];
        Arrays.fill(arr, -1);
        int result = 0;
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int cur = Integer.parseInt(st.nextToken());
        	int pos = Integer.parseInt(st.nextToken());
        	
        	if ((arr[cur] == 0 && pos == 1) || (arr[cur] == 1 && pos == 0)) result++;
        	
        	arr[cur] = pos;
        }
        System.out.print(result);
    }
}