import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{i, priorities[i]});
        }
        Arrays.sort(priorities);
        int cur = priorities.length - 1;
        int cnt = 0;
        while (true) {
            int[] p = q.peek();
            if (p[1] == priorities[cur]) {
                q.poll();
                cur--;
                cnt++;
                if (p[0] == location) {
                    break;
                }
            } else {
                q.offer(q.poll());
            }
        }
        return cnt;
    }
}