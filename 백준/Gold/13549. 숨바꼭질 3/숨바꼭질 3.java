import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static Deque<Point> q;
    static boolean[] visited;
    static class Point {
        int pos;
        int time;
        Point(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (K <= N) {
            System.out.print(N - K);
            System.exit(0);
        }
        q = new ArrayDeque<>();
        visited = new boolean[100_001];
        q.offer(new Point(N, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();
            visited[p.pos] = true;
            if (p.pos == K) {
                System.out.print(p.time);
                break;
            }
            if (p.pos * 2 <= 100_000 && !visited[p.pos * 2]) {
                q.offerFirst(new Point(p.pos * 2, p.time));
            }
            if (p.pos + 1 <= 100_000 && !visited[p.pos + 1]) {
                q.offer(new Point(p.pos + 1, p.time + 1));
            }
            if (p.pos - 1 >= 0 && !visited[p.pos - 1]) {
                q.offer(new Point(p.pos - 1, p.time + 1));
            }
        }
    }
}