import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[] arr;
    static int[] sumArr;
    static int mx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sumArr = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            sumArr[0] += arr[i];
        }

        for (int i = 1; i <= n - k; i++) {
            sumArr[i] = sumArr[i - 1] - arr[i - 1] + arr[i + k - 1];
        }

        mx = Integer.MIN_VALUE;
        for  (int i = 0; i <= n - k; i++) {
            mx = Math.max(mx, sumArr[i]);
        }

        System.out.print(mx);
    }
}