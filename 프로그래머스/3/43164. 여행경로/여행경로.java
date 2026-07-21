import java.util.*;
class Solution {
    static class Ticket {
        String to;
        int idx;
        Ticket(String to, int idx) {
            this.to = to;
            this.idx = idx;
        }
    }
    static int n;
    static HashMap<String, List<Ticket>> map = new HashMap<>();
    static List<String> arr = new ArrayList<>();
    static boolean[] visited;
    static String[] answer;
    static boolean found;
    
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        for (int i = 0; i < n; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            if (map.get(from) == null) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(new Ticket(to, i));
        }
        for (List<Ticket> list : map.values()) {
            list.sort((a, b) -> a.to.compareTo(b.to));
        }
        visited = new boolean[n];
        answer = new String[n + 1];
        dfs("ICN", 0);
        return answer;
    }
    static void dfs(String cur, int depth) {
        if (found) return;
        
        answer[depth] = cur;
        if (depth == n) {
            found = true;
            return;
        }
        
        if (map.get(cur) == null) return;
        
        for (Ticket t : map.get(cur)) {
            if (visited[t.idx]) continue;
            visited[t.idx] = true;
            dfs(t.to, depth + 1);
            visited[t.idx] = false;
        }
    }
}