import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static int[][] maze;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static class Edge {
    int x;
    int y;
    int cost;
    Edge(int x, int y, int cost) {
      this.x = x;
      this.y = y;
      this.cost = cost;
    }
  }
  static class Node implements Comparable<Node> {
    int x;
    int y;
    int totalDistance;
    Node(int x, int y, int totalDistance) {
      this.x = x;
      this.y = y;
      this.totalDistance = totalDistance;
    }
    @Override
    public int compareTo(Node o) {
      return totalDistance - o.totalDistance;
    }
  }
  static int[][] distance;
  static Deque<Node> dq;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    maze = new int[M][N];
    for (int i = 0; i < M; i++) {
      String input = br.readLine();
      for (int j = 0; j < N; j++) {
        maze[i][j] = input.charAt(j) - '0';
      }
    }
    distance = new int[M][N];
    for (int i = 0; i < M; i++) {
      Arrays.fill(distance[i], Integer.MAX_VALUE);
    }
    dq = new ArrayDeque<>();
    distance[0][0] = 0;
    dq.offer(new Node(0, 0, 0));
    while (!dq.isEmpty()) {
      Node cur = dq.poll();
      if (cur.totalDistance > distance[cur.x][cur.y]) continue;
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
        if (cur.totalDistance + maze[nx][ny] < distance[nx][ny]) {
          distance[nx][ny] = cur.totalDistance + maze[nx][ny];
          dq.offer(new Node(nx, ny, distance[nx][ny]));
        }
      }
    }
    System.out.print(distance[M - 1][N - 1]);
  }
}