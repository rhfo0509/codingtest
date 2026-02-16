import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt, cur;
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Meeting o) {
            if (start == o.start) {
                return end - o.end;
            }
            return start - o.start;
        }
    }
    static PriorityQueue<Meeting> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new Meeting(s, e));
        }
        cnt = 0;
        cur = -1;
        while (!pq.isEmpty()) {
            Meeting m = pq.poll();
            if (m.start >= cur) {
                cnt++;
                cur = m.end;

            } else if (m.end < cur) {
                cur = m.end;
            }
        }
        System.out.print(cnt);
    }
}