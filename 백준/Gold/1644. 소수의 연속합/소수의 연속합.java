import java.io.*;
import java.util.*;
public class Main {
    static int n, count;
    static boolean[] visited;
    static List<Integer> primeNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.print(0);
            System.exit(0);
        }
        visited = new boolean[n + 1];
        // 에라토스테네스의 체
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!visited[i]) {
                int j = 2;
                while (i * j <= n) {
                    visited[i * j] = true;
                    j++;
                }
            }
        }
        primeNumber = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!visited[i]) {
                primeNumber.add(i);
            }
        }

        int start = 0;
        int end = 0;
        int sum = primeNumber.get(0);

        while (start <= end) {

            if (sum == n) {
                count++;
                sum -= primeNumber.get(start);
                start++;
                end++;
                if (end == primeNumber.size()) break;
                sum += primeNumber.get(end);
            } else if (sum > n) {
                sum -= primeNumber.get(start);
                start++;
            } else {
                end++;
                if (end == primeNumber.size()) break;
                sum += primeNumber.get(end);
            }

        }

        System.out.print(count);
    }
}
