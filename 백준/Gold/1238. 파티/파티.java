import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

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
            return this.totalDistance - o.totalDistance;
        }
    }

    static int N, M, X;
    static List<List<Edge>> graph1, graph2;
    static int[] distance1, distance2;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph1 = new ArrayList<>();
        graph2 = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph1.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // A에서 X로 가는 경우
            graph1.get(from).add(new Edge(to, weight));

            // X에서 A로 가는 경우
            // ★핵심: 간선을 역방향으로 넣는다. (다익스트라로 풀기 위해서)
            graph2.get(to).add(new Edge(from, weight));
        }

        distance1 = new int[N + 1];
        Arrays.fill(distance1, Integer.MAX_VALUE);
        distance2 = new int[N + 1];
        Arrays.fill(distance2, Integer.MAX_VALUE);

        dijkstra(X, distance1, graph1);
        dijkstra(X, distance2, graph2);

        // 모든 학생들은 집에서 X에 갈수 있고, X에서 집으로 돌아올 수 있으므로
        // distance가 INF가 되는 경우는 존재하지 않음
        result = 0;

        for (int i = 1; i <= N; i++) {
            result = Math.max(result, distance1[i] + distance2[i]);
        }

        System.out.print(result);
    }

    static void dijkstra(int start, int[] distance, List<List<Edge>> graph) {
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (distance[node.to] < node.totalDistance) {
                continue;
            }

            for (Edge next : graph.get(node.to)) {
                if (distance[node.to] + next.weight < distance[next.to]) {
                    distance[next.to] = distance[node.to] + next.weight;
                    pq.offer(new Node(next.to, distance[next.to]));
                }
            }
        }
    }
}