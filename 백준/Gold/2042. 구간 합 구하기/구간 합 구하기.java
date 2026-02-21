import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] tree, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        tree = new long[N + 1];
        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            long cur = Long.parseLong(br.readLine());
            arr[i] = cur;
            add(i, cur);
        }
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                long delta = c - arr[b];
                arr[b] = c;
                add(b, delta);
            } else {
                int c = Integer.parseInt(st.nextToken());
                System.out.println(sum(c) - sum(b - 1));
            }
        }

    }
    static void add(int i, long cur) {
        while (i <= N) {
            tree[i] += cur;
            i += (i & -i);
        }
    }
    static long sum(int i) {
        long res = 0;
        while (i > 0) {
            res += tree[i];
            i -= (i & -i);
        }
        return res;
    }
}