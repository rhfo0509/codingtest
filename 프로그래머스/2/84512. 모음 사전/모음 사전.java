import java.util.*;
class Solution {
    static int n, count;
    static int result;
    static String[] str = {"A", "E", "I", "O", "U"};
    static StringBuilder sb = new StringBuilder();
    static String target;
    public int solution(String word) {
        n = str.length;
        target = word;
        dfs(0);
        return result;
    }
    public void dfs(int depth) {
        count++;
        if (target.equals(sb.toString())) {
            result = count - 1;
            return;
        }
        if (depth == n) return;
        for (int i = 0; i < n; i++) {
            sb.append(str[i]);
            dfs(depth + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}