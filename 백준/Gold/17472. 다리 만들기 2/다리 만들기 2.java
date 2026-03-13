import java.io.*;
import java.util.*;
public class Main {
    static int N, M, cur;
    static int[][] map;
    static boolean[][] visited;
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
    static List<Edge> graph;
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
    static Deque<Point> dq;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cur = 1;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    map[i][j] = cur;
                    visited[i][j] = true;
                    dq = new ArrayDeque<>();
                    dq.offer(new Point(i, j));
                    bfs();
                    cur++;
                }
            }
        }
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    calcMinDist(i, j);
                }
            }
        }
        parent = new int[cur];
        for (int i = 1; i < cur; i++) {
            parent[i] = i;
        }
        Collections.sort(graph);
        System.out.print(kruskal());
    }
    static void bfs() {
        while (!dq.isEmpty()) {
            Point p = dq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                map[nx][ny] = cur;
                visited[nx][ny] = true;
                dq.offer(new Point(nx, ny));
            }
        }
    }
    static void calcMinDist(int x, int y) {
        int curNum = map[x][y];
        for (int i = 0; i < 4; i++) {
            int dist = 0;
            int cx = x;
            int cy = y;
            while (true) {
                cx += dx[i];
                cy += dy[i];
                if (cx < 0 || cx >= N || cy < 0 || cy >= M || map[cx][cy] == curNum) {
                    break;
                }
                if (map[cx][cy] != 0 && map[cx][cy] != curNum && dist <= 1) {
                    break;
                }
                if (map[cx][cy] != 0 && map[cx][cy] != curNum && dist > 1) {
                    graph.add(new Edge(curNum, map[cx][cy], dist));
                    break;
                }
                dist++;
            }
        }
    }
    static void union(int a, int b) {
        // parent를 전달받음.
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    static int kruskal() {
        int minDist = 0;
        int cnt = 0;
        for (Edge e : graph) {
            int pFrom = find(e.from);
            int pTo = find(e.to);
            if (pFrom == pTo) continue;
            union(pFrom, pTo);
            cnt++;
            minDist += e.cost;
            if (cnt == cur - 2) {
                return minDist;
            }
        }
        return -1;
    }
}