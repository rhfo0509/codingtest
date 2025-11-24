import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int stick = 64;
        int count = 0;
        int cur = 0;
        while (cur != x) {
            if (stick + cur <= x) {
                cur += stick;
                count++;
            }
            stick /= 2;
        }
        System.out.print(count);
    }
}