import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static char[][] arr;
    static boolean[] selected;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        selected = new boolean[25];
        dfs(0, 0, 0);

        System.out.print(result);
    }

    static void dfs(int start, int depth, int yCount) {

        if (yCount >= 4) return;
        if (depth == 7) {
            bfs();
            return;
        }

        for (int i = start; i < 25; i++) {
            selected[i] = true;
            int r = i / 5;
            int c = i % 5;

            if (arr[r][c] == 'Y') {
                dfs(i + 1, depth + 1, yCount + 1);
            } else {
                dfs(i + 1, depth + 1, yCount);
            }
            selected[i] = false;
        }
    }

    static void bfs() {
        boolean[][] visited = new boolean[5][5];
        Deque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < 25; i++) {
            if (selected[i]) {
                int r = i / 5;
                int c = i % 5;

                q.offer(new int[]{r, c});
                visited[r][c] = true;
                break;
            }
        }

        int count = 1;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny] || !selected[nx * 5 + ny]) {
                    continue;
                }

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                count++;

                if (count == 7) {
                    result++;
                    return;
                }
            }
        }
    }
}
