import java.io.*;
import java.util.*;

public class Main {
    static int N, M, G, R;
    static int[][] garden;
    static List<Point> soil, selected;
    static int result;

    static class Point {
        int x;
        int y;
        int t;

        Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Deque<Point> q;
    static int[][] time;
    // 0:방문하지 않음, 1:빨강, 2:초록, 3:꽃
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        garden = new int[N][M];
        soil = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                garden[i][j] = Integer.parseInt(st.nextToken());
                if (garden[i][j] == 2) {
                    soil.add(new Point(i, j, 0));
                }
            }
        }

        result = 0;
        selected = new ArrayList<>();
        dfs1(0, 0);
        System.out.print(result);
    }

    static void dfs1(int start, int depth) {
        if (depth == R + G) {
            dfs2(0, new ArrayList<>());
            return;
        }

        for (int i = start; i < soil.size(); i++) {
            selected.add(soil.get(i));
            dfs1(i + 1, depth + 1);
            selected.remove(selected.size() - 1);
        }
    }

    static void dfs2(int start, List<Point> red) {
        if (red.size() == R) {
            List<Point> green = new ArrayList<>(selected);
            green.removeAll(red);
            bfs(red, green);
            return;
        }

        for (int i = start; i < R + G; i++) {
            red.add(selected.get(i));
            dfs2(i + 1, red);
            red.remove(red.size() - 1);
        }
    }

    static void bfs(List<Point> red, List<Point> green) {
        q = new ArrayDeque<>();
        time = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }
        visited = new int[N][M];

        // 피운 꽃의 개수
        int flowerCount = 0;

        for (Point r : red) {
            q.offer(r);
            time[r.x][r.y] = r.t;
            visited[r.x][r.y] = 1;
        }

        for (Point g : green) {
            q.offer(g);
            time[g.x][g.y] = g.t;
            visited[g.x][g.y] = 2;
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (visited[p.x][p.y] == 3) continue;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nt = p.t + 1;

                // 퍼지지 못하는 경우
                // 1) 범위 벗어난 경우 continue
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 2) 호수 도달한 경우 continue
                else if (garden[nx][ny] == 0) continue;

                // 3) 꽃에 도달한 경우 continue
                else if (visited[nx][ny] == 3) continue;

                // 4) 배양액이 있는데 같은 색의 배양액인 경우 continue
                else if ((visited[nx][ny] == 1 && visited[p.x][p.y] == 1) || (visited[nx][ny] == 2 && visited[p.x][p.y] == 2)) continue;

                // 5) 배양액이 있는데 이미 도달한 시점이 이전인 경우 continue
                else if ((visited[nx][ny] == 1 || visited[nx][ny] == 2) && time[nx][ny] < nt) continue;

                // 퍼지는 경우
                // 1) 배양액이 없는 경우
                else if (visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[p.x][p.y];
                    time[nx][ny] = nt;
                    q.offer(new Point(nx, ny, nt));
                }

                // 2) 배양액이 있는데, 다른 색이고 같은 시간에 도달한 경우
                else {
                    visited[nx][ny] = 3;
                    flowerCount++;
                }
            }
        }

        result = Math.max(result, flowerCount);
    }
}