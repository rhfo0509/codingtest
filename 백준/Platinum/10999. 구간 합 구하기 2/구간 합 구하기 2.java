import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[] arr, seg, lazy;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        seg = new long[4 * N];
        lazy = new long[4 * N];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        build(1, 1, N);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long d = Long.parseLong(st.nextToken());
                update(1, 1, N, b, c, d);
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
        seg[node] = seg[node * 2] + seg[node * 2 + 1];
    }
    static void update_lazy(int node, int start, int end) {
        if (lazy[node] != 0) {
            seg[node] += (end - start + 1L) * lazy[node];
        }
        if (start != end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }
        lazy[node] = 0;
    }
    static void update(int node, int start, int end, int left, int right, long value) {
        update_lazy(node, start, end);
        if (right < start || left > end) return;
        if (left <= start && end <= right) {
            seg[node] += (end - start + 1L) * value;
            if (start != end) {
                lazy[node * 2] += value;
                lazy[node * 2 + 1] += value;
            }
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, left, right, value);
        update(node * 2 + 1, mid + 1, end, left, right, value);
        seg[node] = seg[node * 2] + seg[node * 2 + 1];
    }
    static long query(int node, int start, int end, int left, int right) {
        update_lazy(node, start, end);
        if (right < start || left > end) return 0;
        if (left <= start && end <= right) return seg[node];
        int mid = (start + end) / 2;
        long q1 = query(node * 2, start, mid, left, right);
        long q2 = query(node * 2 + 1, mid + 1, end, left, right);
        return q1 + q2;
    }
}