import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[] arr, seg1, seg2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        seg1 = new long[4 * N];
        seg2 = new long[4 * N];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        build(1, 1, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(queryMin(1, 1, N, a, b))
                    .append(" ")
                    .append(queryMax(1, 1, N, a, b))
                    .append("\n");
        }
        System.out.print(sb);
    }
    static void build(int node, int start, int end) {
        if (start == end) {
            seg1[node] = arr[start];
            seg2[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);
        seg1[node] = Math.max(seg1[node * 2], seg1[node * 2 + 1]);
        seg2[node] = Math.min(seg2[node * 2], seg2[node * 2 + 1]);
    }
    static long queryMax(int node, int start, int end, int left, int right) {
        if (start > right || end < left) return 0;
        if (start >= left && end <= right) return seg1[node];
        int mid = (start + end) / 2;
        long q1 = queryMax(node * 2, start, mid, left, right);
        long q2 = queryMax(node * 2 + 1, mid + 1, end, left, right);
        return Math.max(q1, q2);
    }
    static long queryMin(int node, int start, int end, int left, int right) {
        if (start > right || end < left) return Long.MAX_VALUE;
        if (start >= left && end <= right) return seg2[node];
        int mid = (start + end) / 2;
        long q1 = queryMin(node * 2, start, mid, left, right);
        long q2 = queryMin(node * 2 + 1, mid + 1, end, left, right);
        return Math.min(q1, q2);
    }
}