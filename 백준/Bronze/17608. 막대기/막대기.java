import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[N - 1 - i] = Integer.parseInt(br.readLine());
        }

        int h = 0, result = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > h) {
                h = arr[i];
                result++;
            }
        }
        System.out.print(result);
    }
}