import java.io.*;
import java.util.*;
public class Main {
    static int N, E;
    static List<List<Edge>> graph;
    static int v1, v2, c1, c2;
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
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        c1 = calc(v1, v2);
        c2 = calc(v2, v1);
        if (c1 == Integer.MAX_VALUE && c2 == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(Math.min(c1, c2));
        }

    }
    static int dijkstra(int start, int end, int flag) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (distance[cur.to] < cur.totalDistance) continue;
            for (Edge next : graph.get(cur.to)) {
                if (distance[next.to] >= distance[cur.to] + next.cost) {
                    distance[next.to] = distance[cur.to] + next.cost;
                    pq.offer(new Node(next.to, distance[cur.to] + next.cost));
                }
            }
        }

        return distance[end];
    }

    static int calc(int v1, int v2) {

        int d1 = dijkstra(1, v1, 0);
        int d2 = dijkstra(v1, v2, 0);
        int d3 = dijkstra(v2, N, 1);
        if (d1 == Integer.MAX_VALUE || d2 == Integer.MAX_VALUE || d3 == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        else return d1 + d2 + d3;
    }
}
