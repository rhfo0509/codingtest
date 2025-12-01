import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("int");
        for (int i = 0; i < N; i += 4) {
            sb.insert(0, "long ");
        }
        System.out.print(sb);
    }
}