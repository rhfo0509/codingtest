import java.util.*;
class Solution {
    static int n, m;
    static int[] visited;
    public int solution(String begin, String target, String[] words) {
        n = words.length;
        m = words[0].length();
        visited = new int[n];
        int answer = bfs(begin, target, words);
        return answer;
    }
    static boolean calc(String l, String r) {
        int cnt = 0;
        for (int j = 0; j < m; j++) {
            if (l.charAt(j) == r.charAt(j)) {
                cnt++;
            }
        }
        if (cnt == m - 1) {
            return true;
        }
        return false;
    }
    static int bfs(String begin, String target, String[] words) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (calc(begin, words[i])) {
                visited[i] = 1;
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (words[cur].equals(target)) return visited[cur];
            for (int i = 0; i < n; i++) {
                if (visited[i] > 0) continue;
                if (calc(words[cur], words[i])) {
                    visited[i] = visited[cur] + 1;
                    q.offer(i);
                }
            }
        }
        return 0;
    }
}