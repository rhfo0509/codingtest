import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int w, h, result;
    static int[][] arr;
    static boolean[][] visited;
    static Deque<int[]> q;

    static int[] dx = {0, 0, -1, 1, 1, -1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, 1, 1, -1, -1};

    static void bfs(int x, int y) {
        q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            int px = p[0];
            int py = p[1];

            for (int i = 0; i < 8; i++) {

                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || arr[nx][ny] == 0 || visited[nx][ny]) continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = 0;
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        result += 1;
                    }
                }
            }

            System.out.println(result);
        }
    }
}