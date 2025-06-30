import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int sum = 0;
        int count = 0;
        for (int i = Math.round(n * 0.15f); i < n - Math.round(n * 0.15f); i++) {
            sum += arr[i];
            count++;
        }
        int result = Math.round(sum / (float) count);
        System.out.print(result);
    }
}