import java.io.*;
import java.util.*;

public class Main {
    static int V, E, cnt, res;
    static List<List<Edge>> graph;
    static class Edge implements Comparable<Edge> {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
    static PriorityQueue<Edge> pq;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Edge(B, C));
            graph.get(B).add(new Edge(A, C));
        }

        // Prim
        pq = new PriorityQueue<>();
        visited = new boolean[V + 1];
        pq.offer(new Edge(1, 0));
        cnt = res = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.to]) continue;
            visited[cur.to] = true;
            res += cur.weight;
            if (++cnt == V) break;
            for (Edge next : graph.get(cur.to)) {
                if (!visited[next.to]) {
                    pq.offer(new Edge(next.to, next.weight));
                }
            }
        }
        System.out.print(res);
    }
}