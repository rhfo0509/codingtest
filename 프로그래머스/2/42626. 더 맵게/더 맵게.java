import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }
        int answer = 0;
        while (pq.peek() < K) {
            if (pq.size() == 1) return -1;
            answer++;
            int food = pq.poll() + (pq.poll() * 2);
            pq.offer(food);
        }
        return answer;
    }
}