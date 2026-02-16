import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    static long start, end, res;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        start = 1;
        end = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }
        while (start <= end) {
            long mid = (start + end) / 2;
            long cur = 0;
            for (int i = 0; i < K; i++) {
                cur += arr[i] / mid;
            }
            if (cur >= N) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.print(res);
    }
}