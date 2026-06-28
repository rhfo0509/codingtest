import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int n : arr) {
            if (q.isEmpty() || q.peek() != n) {
                q.push(n);
            }
        }
        int[] answer = new int[q.size()];
        int i = 0;
        while (!q.isEmpty()) {
            answer[i++] = q.pollLast();
        }
        return answer;
    }
}