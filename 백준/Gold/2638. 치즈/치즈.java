import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int elapsedTime, cheese;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        cheese = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    cheese++;
                }
            }
        }

        elapsedTime = 0;
        while (true) {
            elapsedTime++;
            bfs();

            int[][] newArr = arr.clone();
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (arr[i][j] == 1) {
                        int count = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx < 0 || nx >= N | ny < 0 || ny >= M || !visited[nx][ny]) {
                                continue;
                            }
                            count++;
                        }
                        if (count >= 2) {
                            newArr[i][j] = 0;
                            cheese--;
                        }
                    }
                }
            }
            if (cheese == 0) {
                break;
            }
            arr = newArr;
        }
        System.out.print(elapsedTime);
    }

    static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        visited = new boolean[N][M];
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                if (nx < 0 || nx >= N | ny < 0 || ny >= M || visited[nx][ny] || arr[nx][ny] == 1) {
                    continue;
                }
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
