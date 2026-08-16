import java.util.*;
class Solution {
    static int n, count;
    static int[] mnFatigue, fatigueCost;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {   
        n = dungeons.length;
        mnFatigue = new int[n];
        fatigueCost = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            mnFatigue[i] = dungeons[i][0];
            fatigueCost[i] = dungeons[i][1];
        }
        dfs(0, k);
        return count;
    }
    public void dfs(int depth, int fatigue) {
        count = Math.max(count, depth);
        if (depth == n) {
            count = n;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && fatigue >= mnFatigue[i]) {
                visited[i] = true;
                dfs(depth + 1, fatigue - fatigueCost[i]);
                visited[i] = false;
            }
        }
    }
}