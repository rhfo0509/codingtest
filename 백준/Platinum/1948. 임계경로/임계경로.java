import java.io.*;
import java.util.*;
public class Main {
  static class Edge {
    int to;
    int cost;
    Edge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
  }
  static List<List<Edge>> graph, revGraph;
  static int n, m, han, rome, cnt;
  static int[] dist, indegree;
  static Deque<Integer> q;
  static boolean[][] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    graph = new ArrayList<>();
    revGraph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
      revGraph.add(new ArrayList<>());
    }
    dist = new int[n + 1];
    indegree = new int[n + 1];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph.get(u).add(new Edge(v, w));
      revGraph.get(v).add(new Edge(u, w));
      indegree[v]++;
    }
    st = new StringTokenizer(br.readLine());
    han = Integer.parseInt(st.nextToken());
    rome = Integer.parseInt(st.nextToken());
    q = new ArrayDeque<>();
    q.offer(han);
    // 위상 정렬
    while (!q.isEmpty()) {
      int cur = q.poll();
      for (Edge next : graph.get(cur)) {
        if (--indegree[next.to] == 0) {
          q.offer(next.to);
        }
        dist[next.to] = Math.max(dist[next.to], dist[cur] + next.cost);
      }
    }
    visited = new boolean[n + 1][n + 1];
    q = new ArrayDeque<>();
    q.offer(rome);
    // BFS (역추적)
    while (!q.isEmpty()) {
      int cur = q.poll();
      for (Edge next : revGraph.get(cur)) {
        if (next.cost + dist[next.to] != dist[cur]) continue;
        if (visited[cur][next.to]) continue;
        visited[cur][next.to] = true;
        cnt++;
        q.offer(next.to);
      }
    }
    System.out.println(dist[rome]);
    System.out.println(cnt);
  }
}