import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, s, e;
    static List<List<Edge>> graph;
    static int[] distance, path;
    static PriorityQueue<Node> pq;
    static class Node implements Comparable<Node> {
        int to;
        int totalDistance;
        Node(int to, int totalDistance) {
            this.to = to;
            this.totalDistance = totalDistance;
        }
        @Override
        public int compareTo(Node o) {
            return this.totalDistance - o.totalDistance;
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
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        path = new int[n + 1];
        dijkstra(s);
        System.out.println(distance[e]);

        int idx = e;
        int count = 0;
        List<Integer> res = new ArrayList<>();
        while (idx != 0) {
            count++;
            res.add(idx);
            idx = path[idx];
        }
        System.out.println(count);
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i) + " ");
        }
    }
    static void dijkstra(int start) {
        distance = new int[n + 1];
        Arrays.fill(distance, 100_000_000);
        pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (distance[cur.to] < cur.totalDistance) continue;

            for (Edge next : graph.get(cur.to)) {
                if (distance[cur.to] + next.cost < distance[next.to]) {
                    distance[next.to] = distance[cur.to] + next.cost;
                    pq.offer(new Node(next.to, distance[next.to]));
                    path[next.to] = cur.to;
                }
            }
        }
    }
}
