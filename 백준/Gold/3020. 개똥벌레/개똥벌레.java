import java.io.*;
import java.util.*;

public class Main {
    static int N, H, mn, cur, cnt;
    static int[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        sum = new int[H + 1];
        for (int i = 0; i < N; i++) {
            int l = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                sum[0] += 1;
                sum[l + 1 - 1] -= 1;
            } else {
                sum[H - l] += 1;
                sum[H] -= 1;
            }
        }
        mn = Integer.MAX_VALUE;
        cur = 0;
        cnt = 0;
        for (int i = 0; i < H; i++) {
            cur += sum[i];
            if (cur < mn) {
                mn = cur;
                cnt = 1;
            } else if (cur == mn) {
                cnt++;
            }
        }
        System.out.println(mn + " " + cnt);
    }
}