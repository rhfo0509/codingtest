import java.io.*;
import java.util.*;
public class Main {
    static int N, M, result;
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) bfs(i, j);
            }
        }
        System.out.print(result);
    }
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Deque<Point> q;
    static int[][] dist;
    static boolean[][] visited;
    static void bfs(int x, int y) {
        q = new ArrayDeque<>();
        dist = new int[N][M];
        visited = new boolean[N][M];
        q.offer(new Point(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (A[p.x][p.y] == 1) {
                result = Math.max(result, dist[p.x][p.y]);
                return;
            }
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
                dist[nx][ny] = dist[p.x][p.y] + 1;
                visited[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }

    }
}