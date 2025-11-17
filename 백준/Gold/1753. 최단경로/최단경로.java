import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, K;
    static List<List<Edge>> graph;
    static class Node implements Comparable<Node> {
        int to;
        int totalDistance;
        Node(int to, int totalDistance) {
            this.to = to;
            this.totalDistance = totalDistance;
        }
        @Override
        public int compareTo(Node o) {
            return totalDistance - o.totalDistance;
        }
    }
    static class Edge {
        int to;
        int cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }

        dijkstra(K);
    }
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[V + 1];
        Arrays.fill(distance, 10_000_000);

        pq.offer(new Node(start, 0));
        distance[start] = 0;


        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (distance[cur.to] < cur.totalDistance) continue;

            for (Edge next : graph.get(cur.to)) {
                if (distance[next.to] > distance[cur.to] + next.cost) {
                    distance[next.to] = distance[cur.to] + next.cost;
                    pq.offer(new Node(next.to, distance[next.to]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == 10_000_000) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}