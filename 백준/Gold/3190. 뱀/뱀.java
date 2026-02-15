import java.io.*;
import java.util.*;

public class Main {
    static int N, K, L, pos, time, x, y;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static HashMap<Integer, Character> map;
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Deque<Point> snake;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r - 1][c - 1] = 1;
        }
        L = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            map.put(X, C);
        }
        pos = 0;
        time = x = y = 0;
        snake = new ArrayDeque<>();
        snake.offer(new Point(0, 0));
        board[x][y] = 2;
        while (true) {
            time++;
            x += dx[pos];
            y += dy[pos];
            if (x < 0 || x >= N || y < 0 || y >= N) break;
            if (board[x][y] == 2) break;
            if (board[x][y] == 0) {
                Point p = snake.poll();
                board[p.x][p.y] = 0;
            }
            snake.offer(new Point(x, y));
            board[x][y] = 2;
            if (map.containsKey(time)) {
                if (map.get(time) == 'D') {
                    pos = (pos + 1) % 4;
                } else {
                    pos = (pos + 3) % 4;
                }
            }
        }
        System.out.print(time);
    }
}