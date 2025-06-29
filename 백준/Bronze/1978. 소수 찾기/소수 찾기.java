import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] visited = new boolean[1001];
        // 1은 소수가 아니다.
        visited[1] = true;
        for (int i = 2; i < Math.sqrt(1000) + 1; i++) {
            if (!visited[i]) {
                int j = 2;
                while (i * j <= 1000) {
                    visited[i * j] = true;
                    j += 1;
                }
            }
        }
        int primeCount = 0;
        for (int j : arr) {
            if (!visited[j]) {
                primeCount += 1;
            }
        }

        System.out.print(primeCount);
    }
}