import java.util.*;
class Solution {
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
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static List<List<Edge>> graph;
    static int[] distance;
    static PriorityQueue<Node> pq;
    public int solution(int n, int[][] edge) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] v : edge) {
            graph.get(v[0]).add(new Edge(v[1], 1));
            graph.get(v[1]).add(new Edge(v[0], 1));
        }
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq = new PriorityQueue<>();
        distance[1] = 0;
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (distance[cur.to] < cur.totalDistance) {
                continue;
            }
            for (Edge next : graph.get(cur.to)) {
                if (distance[cur.to] + next.weight < distance[next.to]) {
                    distance[next.to] = distance[cur.to] + next.weight;
                    pq.offer(new Node(next.to, distance[next.to]));
                }
            }
        }
        int mx = 0;
        int answer = 0;
        for (int d : distance) {
            if (d != Integer.MAX_VALUE) {
                mx = Math.max(mx, d);
            }
        }
        for (int d : distance) {
            if (mx == d) {
                answer++;
            }
        }
        return answer;
    }
}