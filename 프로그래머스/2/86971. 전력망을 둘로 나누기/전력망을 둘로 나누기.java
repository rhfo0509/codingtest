import java.util.*;
class Solution {
    static List<List<Integer>> graph;
    static int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));
            int c1 = bfs(wire[0], n);
            int c2 = bfs(wire[1], n);
            answer = Math.min(answer, Math.abs(c1 - c2));
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        return answer;
    }
    public int bfs(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(start);
        
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return count;
    }
}