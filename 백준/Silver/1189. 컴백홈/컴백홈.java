import java.io.*;
import java.util.*;
public class Main {
    static int R, C, K, count;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        visited = new boolean[R][C];
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);
        System.out.print(count);
    }
    static void dfs(int x, int y, int d) {
        if (x == 0 && y == C - 1) {
            if (d == K) count++;
            return;
        }
        if (d == K) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || arr[nx][ny] == 'T') continue;
            visited[nx][ny] = true;
            dfs(nx, ny, d + 1);
            visited[nx][ny] = false;
        }
    }
}