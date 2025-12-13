import java.io.*;
import java.util.*;
public class Main {
    static int N, idx, minDist;
    static int[][] map, dist;
    static boolean[][] visited;
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        idx = 1;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs1(i, j);
                    idx++;
                }
            }
        }
        minDist = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    visited = new boolean[N][N];
                    dist = new int[N][N];
                    bfs2(i, j);
                }
            }
        }
        System.out.print(minDist - 1);
    }
    static void bfs1(int x, int y) {
        Deque<Point> q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        map[x][y] = idx;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 0 || visited[nx][ny]) continue;
                q.offer(new Point(nx, ny));
                visited[nx][ny] = true;
                map[nx][ny] = idx;
            }
        }
    }
    static void bfs2(int x, int y) {
        Deque<Point> q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (dist[p.x][p.y] >= minDist) break;
            if (map[p.x][p.y] != 0 && map[p.x][p.y] != map[x][y]) {
                minDist = dist[p.x][p.y];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == map[x][y] || visited[nx][ny]) continue;
                q.offer(new Point(nx, ny));
                visited[nx][ny] = true;
                dist[nx][ny] = dist[p.x][p.y] + 1;
            }
        }
    }
}