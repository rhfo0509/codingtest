import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            int result = 0;
            for (int j = 0; j < 20; j++) {
                int pos = j;
                int num = Integer.parseInt(st.nextToken());
                while (pos > 0 && arr[pos - 1] > num) {
                    arr[pos] = arr[pos - 1];
                    pos -= 1;
                    result += 1;
                }
                arr[pos] = num;
            }
            System.out.println(T + " " + result);
        }
    }
}