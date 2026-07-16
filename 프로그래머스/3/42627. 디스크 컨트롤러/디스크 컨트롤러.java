import java.util.*;
class Solution {
    static class HDD implements Comparable<HDD> {
        int i;
        int s;
        int l;
        HDD(int i, int s, int l) {
            this.i = i;
            this.s = s;
            this.l = l;
        }
        @Override
        public int compareTo(HDD o) {
            if (this.l == o.l) {
                if (this.s == o.s) {
                    return this.i - o.i;
                }
                return this.s - o.s;
            }
            return this.l - o.l;
        }
    }
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        PriorityQueue<HDD> pq = new PriorityQueue<>();
        int idx = 1;
        int cnt = 1;
        int time = jobs[0][0] + jobs[0][1];
        
        int taTime = jobs[0][1];
        while (cnt < jobs.length) {
            
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(new HDD(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            // 이전 작업이 끝날때까지 다른 작업이 요청을 보내지 않을 수도 있다.
            if (pq.isEmpty()) {
                pq.offer(new HDD(idx, jobs[idx][0], jobs[idx][1]));
                time = jobs[idx][0];
                idx++;
            }
            
            HDD cur = pq.poll();
            taTime += (time + cur.l - cur.s);
            time += cur.l;
            cnt++;
        }

        return taTime / jobs.length;
    }
}