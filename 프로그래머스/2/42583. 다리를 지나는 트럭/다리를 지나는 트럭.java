import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }
        int idx = 0;
        int cnt = 0;
        int time = 1;
        int curWeight = 0;
        while (true) {
            if (q.peek() > 0) {
                cnt++;
                if (cnt == truck_weights.length) {
                    break;
                }
            }
            curWeight -= q.poll();
            if (idx < truck_weights.length && curWeight + truck_weights[idx] <= weight) {
                curWeight += truck_weights[idx];
                q.offer(truck_weights[idx]);
                idx += 1;
            } else {
                q.offer(0);
            }
            time += 1;
        }
        return time;
    }
}