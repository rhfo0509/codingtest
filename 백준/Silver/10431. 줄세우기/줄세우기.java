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
            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int result = 0;
            for (int j = 0; j < 20; j++) {
                int curNum = arr[j];
                for (int k = j - 1; k >= 0; k--) {
                    if (arr[k] > curNum) {
                        result += 1;
                    }
                }
            }
            System.out.println(T + " " + result);
        }
    }
}
