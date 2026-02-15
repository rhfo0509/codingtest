import java.io.*;
import java.util.*;

public class Main {
    static int N, M, from, to;
    static class Edge {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
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
    static List<List<Edge>> graph;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }

        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[from] = 0;
        dijkstra(from);
        System.out.print(distance[to]);
    }
    static void dijkstra(int from) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(from, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (distance[cur.to] < cur.totalDistance) continue;

            for (Edge next : graph.get(cur.to)) {
                if (distance[cur.to] + next.weight < distance[next.to]) {
                    distance[next.to] = distance[cur.to] + next.weight;
                    pq.offer(new Node(next.to, distance[next.to]));
                }
            }
        }
    }
}
