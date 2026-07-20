import java.util.*;
class Solution {
    static boolean[] visited;
    static List<List<Integer>> arr;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    arr.get(i).add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i);
            answer++;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) answer++;
        }
        return answer;
    }
    static void dfs(int cur) {
        for (int next : arr.get(cur)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}