import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int K, W, H;
    static int[][] arr;
    static int[][][] visited;
    static Deque<int[]> q;

    static int[] dx = {-1, 1, 0, 0, -2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {0, 0, -1, 1, -1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[H][W][K + 1];
        System.out.println(bfs());
    }

    private static int bfs() {
        q = new ArrayDeque<>();
        visited[0][0][0] = 1;
        q.offer(new int[] {0, 0, 0});

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];
            int pk = p[2];

            if (px == H - 1 && py == W - 1) {
                return visited[px][py][pk] - 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                int nk = pk;

                if (nx < 0 || nx >= H || ny < 0 || ny >= W || arr[nx][ny] == 1 || visited[nx][ny][nk] > 0) continue;
                visited[nx][ny][nk] = visited[px][py][pk] + 1;
                q.offer(new int[] {nx, ny, nk});
            }

            if (pk + 1 > K) continue;

            for (int i = 4; i < 12; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                int nk = pk + 1;

                if (nx < 0 || nx >= H || ny < 0 || ny >= W || arr[nx][ny] == 1 || visited[nx][ny][nk] > 0) continue;
                visited[nx][ny][nk] = visited[px][py][pk] + 1;
                q.offer(new int[] {nx, ny, nk});
            }
        }

        return -1;
    }
}