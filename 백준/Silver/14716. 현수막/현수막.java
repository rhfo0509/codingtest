import java.io.*;
import java.util.*;

public class Main {
    static int M, N, result;
    static int[][] arr;
    static boolean[][] visited;
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Deque<Point> q;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0;
        q = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    result++;
                }
            }
        }
        System.out.print(result);
    }
    static void bfs(int x, int y) {
        visited[x][y] = true;
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N || arr[nx][ny] == 0 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }
    }
}