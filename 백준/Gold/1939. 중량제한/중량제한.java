import java.io.*;
import java.util.*;
public class Main {
  static int N, M, S, E;
  static class Edge {
    int to;
    int limit;
    Edge(int to, int limit) {
      this.to = to;
      this.limit = limit;
    }
  }
  static class Node implements Comparable<Node> {
    int to;
    int minLimit;
    Node(int to, int minLimit) {
      this.to = to;
      this.minLimit = minLimit;
    }
    @Override
    public int compareTo(Node o) {
      return o.minLimit - minLimit;
    }
  }
  static List<List<Edge>> graph;
  static PriorityQueue<Node> pq;
  static int[] limitArr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      graph.get(A).add(new Edge(B, C));
      graph.get(B).add(new Edge(A, C));
    }
    st = new StringTokenizer(br.readLine());
    S = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    pq = new PriorityQueue<>();
    limitArr = new int[N + 1];
    dijkstra(S);
    System.out.print(limitArr[E]);
  }
  static void dijkstra(int start) {
    limitArr[start] = Integer.MAX_VALUE;
    pq.offer(new Node(start, limitArr[start]));
    while (!pq.isEmpty()) {
      Node cur = pq.poll();
      if (limitArr[cur.to] > cur.minLimit) continue;
      for (Edge next : graph.get(cur.to)) {
        int nextLimit = Math.min(limitArr[cur.to], next.limit);
        if (nextLimit > limitArr[next.to]) {
          limitArr[next.to] = nextLimit;
          pq.offer(new Node(next.to, limitArr[next.to]));
        }
      }
    }
  }
}
