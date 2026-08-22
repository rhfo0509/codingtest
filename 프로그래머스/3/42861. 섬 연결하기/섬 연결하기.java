import java.util.*;
class Solution {
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parent;
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int a, int b) {
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] cost : costs) {
            pq.offer(new Edge(cost[0], cost[1], cost[2]));
        }
        int count = 0;
        int answer = 0;
        while (count < n - 1) {
            Edge cur = pq.poll();
            int pa = find(cur.from);
            int pb = find(cur.to);
            if (pa == pb) continue;
            union(pa, pb);
            count++;
            answer += cur.cost;
        }
        return answer;
    }
}