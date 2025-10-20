import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int Q;
    static int[][] map, dp;
    static boolean[][] visited;

    static Deque<int[]> dq;
    static HashSet<int[]> set;
    static boolean flag; // true면 건물, false면 땅

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(arr[j - 1]);
            }
        }

        visited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                if (map[i][j] == 1) {
                    dp[i][j] += 1;
                }
            }
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            // 구간합 공식
            int count = dp[r2][c2] - dp[r1 - 1][c2] - dp[r2][c1 - 1] + dp[r1 - 1][c1 - 1];
            if (count == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No" + " " + count);
            }
        }
    }

    static void bfs(int x, int y) {
        dq = new ArrayDeque<>();
        set = new HashSet<>();
        flag = true;

        dq.offer(new int[]{x, y});
        set.add(new int[]{x, y});
        visited[x][y] = true;

        while (!dq.isEmpty()) {
            int[] p = dq.poll();
            int px = p[0];
            int py = p[1];

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 1 || nx > N || ny < 1 || ny > M || visited[nx][ny] || map[nx][ny] == 1) {
                    continue;
                }

                if (nx == 1 || nx == N || ny == 1 || ny == M) {
                    flag = false;
                }

                dq.offer(new int[]{nx, ny});
                set.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

        if (flag) {
            for (int[] p : set) {
                map[p[0]][p[1]] = 1;
            }
        }
    }
}