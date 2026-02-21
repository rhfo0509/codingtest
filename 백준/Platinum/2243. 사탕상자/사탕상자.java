import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] tree, arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        tree = new int[1_000_001];
        arr = new int[1_000_001];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A == 1) {
                int target = binarySearch(B);
                sb.append(target).append("\n");
                arr[target] -= 1;
                add(target, -1);
            } else {
                int C = Integer.parseInt(st.nextToken());
                arr[B] += C;
                add(B, C);
            }
        }
        System.out.print(sb);
    }
    static void add(int i, int delta) {
        while (i <= 1_000_000) {
            tree[i] += delta;
            i += (i & -i);
        }
    }
    static int sum(int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i -= (i & -i);
        }
        return res;
    }
    static int binarySearch(int rank) {
        int start = 1;
        int end = 1_000_000;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (sum(mid) < rank) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}