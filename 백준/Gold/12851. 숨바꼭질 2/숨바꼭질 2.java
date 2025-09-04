import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static Deque<int[]> q;
    static int[] time;
    static int[] way;

    static int resTime, resCount;

    static void bfs() {
        q = new ArrayDeque<>();
        // {도달하는 데 걸리는 시간, 현재 위치}
        q.offer(new int[]{0, N});
        time[N] = 0;
        way[N] = 1;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            int curTime = p[0];
            int curPos = p[1];

            if (curPos == K) {
                resTime = curTime;
            }

            // X - 1
            if (curPos - 1 >= 0 && time[curPos - 1] > time[curPos] + 1) {
                q.offer(new int[]{curTime + 1, curPos - 1});
                time[curPos - 1] = time[curPos] + 1;
                way[curPos - 1] += way[curPos];
            } else if (curPos - 1 >= 0 && time[curPos - 1] == time[curPos] + 1) {
                way[curPos - 1] += way[curPos];
            }
            // X + 1
            if (curPos + 1 <= 100_000 && time[curPos + 1] > time[curPos] + 1) {
                q.offer(new int[]{curTime + 1, curPos + 1});
                time[curPos + 1] = time[curPos] + 1;
                way[curPos + 1] += way[curPos];
            } else if (curPos + 1 <= 100_000 && time[curPos + 1] == time[curPos] + 1) {
                way[curPos + 1] += way[curPos];
            }
            // X * 2
            if (curPos * 2 <= 100_000 && time[curPos * 2] > time[curPos] + 1) {
                q.offer(new int[]{curTime + 1, curPos * 2});
                time[curPos * 2] = time[curPos] + 1;
                way[curPos * 2] += way[curPos];
            } else if (curPos * 2 <= 100_000 && time[curPos * 2] == time[curPos] + 1) {
                way[curPos * 2] += way[curPos];
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        way = new int[100_001];

        time = new int[100_001];
        Arrays.fill(time, Integer.MAX_VALUE);
        bfs();
        System.out.println(resTime);
        System.out.println(way[K]);
    }
}