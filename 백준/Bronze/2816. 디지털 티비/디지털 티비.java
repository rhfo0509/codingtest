import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        StringBuilder sb = new StringBuilder();
        
        int k1 = -1;
        int k2 = -1;
        for (int i = 0; i < N; i++) {
        	arr[i] = br.readLine();
        	
        	if (arr[i].equals("KBS1")) {
        		k1 = i;
        	}
        	if (arr[i].equals("KBS2")) {
        		k2 = i;
        	}
        }
        
        for (int i = 1; i <= k1; i++) {
        	sb.append(1);
        }
        
        for (int i = k1 - 1; i >= 0; i--) {
        	sb.append(4);
        }
        
        if (k1 > k2) {
        	k2++;
        }
        
        for (int i = 1; i <= k2; i++) {
        	sb.append(1);
        }
        
        for (int i = k2 - 1; i >= 1; i--) {
        	sb.append(4);
        }

        System.out.println(sb.toString());
    }
}