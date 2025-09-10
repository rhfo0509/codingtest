import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // dp[i]: i번째 인덱스까지 도달했을 때 연결할 수 있는 전깃줄의 최대 갯수
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j][1] < arr[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxCnt = 0;
        for (int cnt : dp) {
            maxCnt = Math.max(maxCnt, cnt);
        }
    
        // 연결할 수 있는 전깃줄의 개수가 최대가 되어야 없애야 하는 전깃줄의 개수가 최소가 됨
        int result = N - maxCnt;
        System.out.println(result);
    }
}