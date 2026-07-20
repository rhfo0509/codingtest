import java.util.*;
class Solution {
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
    static int n, m;
    static int[][] dist;
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        dist = new int[n][m];
        answer = bfs(0, 0, maps);
        return answer;
    }
    static int bfs(int x, int y, int[][] maps) {
        Deque<Point> q = new ArrayDeque<>();
        dist[x][y] = 1;
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == n - 1 && p.y == m - 1) {
                return dist[n - 1][m - 1];
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || dist[nx][ny] > 0 || maps[nx][ny] == 0) {
                    continue;
                }
                dist[nx][ny] = dist[p.x][p.y] + 1;
                q.offer(new Point(nx, ny));
            }
        }
        return -1;
    }
}