import java.util.*;
class Solution {
    static List<List<Integer>> graph1, graph2;
    static boolean[] visited1, visited2;
    public int solution(int n, int[][] results) {
        // 정방향
        graph1 = new ArrayList<>();
        // 역방향
        graph2 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph1.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }
        for (int[] result : results) {
            graph1.get(result[1]).add(result[0]);
            graph2.get(result[0]).add(result[1]);
        }
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited1 = new boolean[n + 1];
            visited2 = new boolean[n + 1];
            dfs(i, graph1, visited1);
            dfs(i, graph2, visited2);
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (visited1[j]) count[i]++;
                if (visited2[j]) count[i]++;
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) answer++;
        }
        return answer;
    }
    static void dfs(int cur, List<List<Integer>> graph, boolean[] visited) {
        visited[cur] = true;
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}