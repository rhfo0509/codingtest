import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int Ai = 0;
        int Bi = 0;
        for (int i = 0; i < 3; i++) {
            Ai += (A.charAt(i) - '0') * (int) Math.pow(10, i);
            Bi += (B.charAt(i) - '0') * (int) Math.pow(10, i);
        }
        System.out.print(Math.max(Ai, Bi));
    }
}
