import java.io.*;
import java.util.*;

public class Main {
    static int N, maxLen, curLen;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        maxLen = 1;
        // 연속해서 커지거나(같은 것 포함)
        curLen = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i - 1] <= arr[i]) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 1;
            }
        }
        // 연속해서 작아지는(같은 것 포함)
        curLen = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i - 1] >= arr[i]) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 1;
            }
        }
        System.out.print(maxLen);
    }
}