import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int c0 = 0;
            for (int j = 0; j < 4; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 0) c0++;
            }
            if (c0 == 0) System.out.println("E");
            else if (c0 == 1) System.out.println("A");
            else if (c0 == 2)  System.out.println("B");
            else if (c0 == 3)  System.out.println("C");
            else System.out.println("D");
        }
    }
}