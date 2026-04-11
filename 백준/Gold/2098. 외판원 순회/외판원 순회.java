import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[][] W, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        // 0이면 갈 수 없는 경우 (단, 자기 자신은 0)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dp[mask][i] : 이전에 방문한 도시들이 mask이고, 이번에 방문할 도시의 번호가 i 일때 비용의 최솟값
        dp = new int[1 << N][N];
        for (int i = 0; i < (1 << N); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // dp[1][0] = 0 : 시작점을 하나 잡고 그 값을 0 으로 초기화한다.
        // 2 -> 3 -> 1 -> 0 -> 2, 0 -> 2 -> 3 -> 1 -> 0 결국 같은 순회고 비용이 같기 때문에
        // 도시 아무거나 시작점을 잡아도 무관하다.
        dp[1][0] = 0;

        // 비트마스킹 dp
        // 모든 방문 집합 (0~2^N-1)에 대해
        for (int mask = 0; mask < (1 << N); mask++) {
            // 현재 마지막 도시 i를 잡고
            for (int i = 0; i < N; i++) {
                // 아직 도달하지 못한 상태면 continue
                if (dp[mask][i] == Integer.MAX_VALUE) continue;
                // 다음 방문할 도시 j를 잡고
                for (int j = 0; j < N; j++) {
                    // 이미 방문했다면 continue
                    if ((mask & (1 << j)) != 0) continue;
                    // i 부터 j 까지 방문할 수 없다면 continue
                    if (W[i][j] == 0) continue;

                    // (j 포함 방문 집합, j)에 대해 (j 포함x 방문 집합, i) + (i, j)가 더 짧으면 갱신
                    int nextMask = mask | (1 << j);
                    dp[nextMask][j] = Math.min(dp[nextMask][j], dp[mask][i] + W[i][j]);
                }
            }
        }

        ans = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            if (dp[(1 << N) - 1][i] == Integer.MAX_VALUE) continue;
            if (W[i][0] == 0) continue;
            ans = Math.min(ans, dp[(1 << N) - 1][i] + W[i][0]);
        }
        System.out.print(ans);
    }
}