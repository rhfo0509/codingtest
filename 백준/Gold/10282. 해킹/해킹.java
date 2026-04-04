import java.io.*;
import java.util.*;
public class Main {
  static int T, n, d, c, cnt, time;
  static List<List<Edge>> graph;
  static class Edge {
    int to;
    int cost;
    Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
  }
  static class Node {
    int to;
    int totalDistance;
    Node(int to, int totalDistance) {
      this.to = to;
      this.totalDistance = totalDistance;
    }
  }
  static PriorityQueue<Node> pq;
  static int[] distance;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      d = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      graph = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
      }
      for (int i = 0; i < d; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        graph.get(b).add(new Edge(a, s));
      }
      pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.totalDistance));
      distance = new int[n + 1];
      Arrays.fill(distance, Integer.MAX_VALUE);
      cnt = 0;
      time = 0;
      dijkstra();
      for (int i = 1; i <= n; i++) {
        if (distance[i] != Integer.MAX_VALUE) {
          cnt++;
          time = Math.max(time, distance[i]);
        }
      }
      System.out.println(cnt + " " + time);
    }
  }
  static void dijkstra() {
    pq.offer(new Node(c, 0));
    distance[c] = 0;
    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      if (cur.totalDistance > distance[cur.to]) continue;
      for (Edge next : graph.get(cur.to)) {
        if (distance[cur.to] + next.cost < distance[next.to]) {
          distance[next.to] = distance[cur.to] + next.cost;
          pq.offer(new Node(next.to, distance[next.to]));
        }
      }
    }
  }
}