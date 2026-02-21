import java.io.*;

public class Main {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        System.out.print(fib(n));
    }
    static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[n] > 0) return dp[n];
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }
}