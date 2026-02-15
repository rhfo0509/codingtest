import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = N + 1;
        int cur = arr[0];
        int start, end = 0;
        for (start = 0; start < N; start++) {
            while (end < N && cur < S) {
                end++;
                if (end != N) {
                    cur += arr[end];
                }
            }
            if (end == N) {
                break;
            }
            res = Math.min(res, end - start + 1);
            cur -= arr[start];
        }

        if (res == N + 1) {
            System.out.print(0);
        } else {
            System.out.print(res);
        }
    }
}
