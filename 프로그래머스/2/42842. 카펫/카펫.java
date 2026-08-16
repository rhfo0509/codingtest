import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int n = brown + yellow;
        for (int h = 2; h * h <= n; h++) {
            if (n % h == 0) {
                int w = n / h;
                int cur = (w - 2) * (h - 2);
                if (cur == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        return answer;
    }
}