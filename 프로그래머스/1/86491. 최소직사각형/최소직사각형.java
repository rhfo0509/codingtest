import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int n = sizes.length;
        int[] mx = new int[n];
        int[] mn = new int[n];
        int w = 0;
        int h = 0;
        for (int i = 0; i < n; i++) {
            mx[i] = Math.max(sizes[i][0], sizes[i][1]);
            mn[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        for (int i = 0; i < n; i++) {
            w = Math.max(w, mx[i]);
            h = Math.max(h, mn[i]);
        }
        int answer = w * h;
        return answer;
    }
}