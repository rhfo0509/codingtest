import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int m = Integer.parseInt(st.nextToken());
        	arr[m - 1][0] = Integer.parseInt(st.nextToken());
        	arr[m - 1][1] = Integer.parseInt(st.nextToken());
        	arr[m - 1][2] = Integer.parseInt(st.nextToken());
        }
        
        int gold = arr[K - 1][0];
        int silver = arr[K - 1][1];
        int bronze = arr[K - 1][2];
        
        Arrays.sort(arr, (a, b) -> {
        	if (a[0] != b[0]) return b[0] - a[0];
        	if (a[1] != b[1]) return b[1] - a[1];
        	return b[2] - a[2];
        });
        
        int rank = 1;
        
        for (int i = 0; i < N; i++) {
        	if (gold == arr[i][0] && silver == arr[i][1] && bronze == arr[i][2]) {
        		break;
        	}

        	rank++;
        }
        System.out.print(rank);
    }
}