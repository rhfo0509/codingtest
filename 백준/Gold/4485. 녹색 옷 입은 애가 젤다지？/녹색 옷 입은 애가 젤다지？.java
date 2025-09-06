import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Node implements Comparable<Node> {
        Point to;
        int totalDistance;
        Node(Point to, int totalDistance) {
            this.to = to;
            this.totalDistance = totalDistance;
        }
        @Override
        public int compareTo(Node o) {
            return totalDistance - o.totalDistance;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int tc;
    static int N;
    static int[][] arr;
    static int[][] distance;
    static PriorityQueue<Node> pq;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        tc = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            distance = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }

            pq = new PriorityQueue<>();
            dijkstra();

            System.out.println("Problem " + tc++ + ": " + distance[N - 1][N - 1]);
        }
    }

    private static void dijkstra() {
        // 시작점 (0, 0)
        distance[0][0] = arr[0][0];
        Node startNode = new Node(new Point(0, 0), arr[0][0]);
        pq.offer(startNode);

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (distance[node.to.x][node.to.y] < node.totalDistance) continue;

            for (int i = 0; i < 4; i++) {
                int nx = node.to.x + dx[i];
                int ny = node.to.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (distance[node.to.x][node.to.y] + arr[nx][ny] < distance[nx][ny]) {
                    distance[nx][ny] = distance[node.to.x][node.to.y] + arr[nx][ny];
                    Node newNode = new Node(new Point(nx, ny), distance[nx][ny]);
                    pq.offer(newNode);
                }
            }
        }
    }
}