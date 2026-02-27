import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] arr;
    static long[] seg;
    static int DIVISOR = 1_000_000_007;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        seg = new long[4 * N];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        build(1, 1, N);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                update(1, 1, N, b, c);
            } else {
                sb.append(query(1, 1, N, b, c)).append("\n");
            }
        }
        System.out.print(sb);
    }
    static void build(int node, int start, int end) {
        if (start == end) {
            seg[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);
        seg[node] = (seg[node * 2] * seg[node * 2 + 1]) % DIVISOR;
    }
    static void update(int node, int start, int end, int index, int value) {
        if (index < start || index > end) return;
        if (start == end) {
            seg[node] = value;
            arr[index] = value;
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, index, value);
        update(node * 2 + 1, mid + 1, end, index, value);
        seg[node] = (seg[node * 2] * seg[node * 2 + 1]) % DIVISOR;
    }
    static long query(int node, int start, int end, int left, int right) {
        if (start > right || end < left) return 1;
        if (start >= left && end <= right) return seg[node];
        int mid = (start + end) / 2;
        long q1 = query(node * 2, start, mid, left, right);
        long q2 = query(node * 2 + 1, mid + 1, end, left, right);
        return (q1 * q2) % DIVISOR;
    }
}