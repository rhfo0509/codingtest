import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, K, maxHeight;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            result = 0;
            maxHeight = 0;
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, arr[i][j]);
                }
            }

            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == maxHeight) {
                        visited[i][j] = true;
                        dfs(i, j, 1, true);
                        visited[i][j] = false;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    private static void dfs(int x, int y, int depth, boolean chance) {

        result = Math.max(result, depth);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

            if (arr[x][y] > arr[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, chance);
                visited[nx][ny] = false;
            } else {
                if (chance) {
                    for (int k = 1; k <= K; k++) {
                        if (arr[nx][ny] - k < arr[x][y]) {
                            arr[nx][ny] -= k;
                            visited[nx][ny] = true;
                            dfs(nx, ny, depth + 1, false);
                            arr[nx][ny] += k;
                            visited[nx][ny] = false;
                        }
                    }
                }
            }
        }
    }
}