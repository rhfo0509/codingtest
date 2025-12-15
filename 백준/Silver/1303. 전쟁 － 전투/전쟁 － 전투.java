import java.io.*;
import java.util.*;
public class Main {
    static int N, M, B, W;
    static char[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        }
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (arr[i][j] == 'B') {
                        B += bfs(i, j, 'B');
                    } else {
                        W += bfs(i, j, 'W');
                    }
                }
            }
        }
        System.out.print(W + " " + B);
    }
    static Deque<Point> q;
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
    static int bfs(int x, int y, int c) {
        q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        int count = 1;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N || arr[nx][ny] != c || visited[nx][ny]) continue;
                q.offer(new Point(nx, ny));
                visited[nx][ny] = true;
                count++;
            }
        }
        return count * count;
    }
}