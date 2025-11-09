import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int[] arr = new int[10];
        for (int i = 0; i < num.length(); i++) {
            arr[num.charAt(i) - '0'] += 1;
        }

        int mx = 0;
        int mx69 = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                mx69 += arr[i];
            } else {
                mx = Math.max(mx, arr[i]);
            }
        }

        if (mx69 % 2 == 0) {
            mx69 /= 2;
        } else {
            mx69 = mx69 / 2 + 1;
        }

        System.out.print(Math.max(mx, mx69));
    }
}