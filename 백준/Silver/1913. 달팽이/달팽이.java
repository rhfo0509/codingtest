import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, d, cur, cx, cy, target, tx, ty;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        d = 0;
        cx = 0;
        cy = 0;
        cur = n * n;
        while (cur > 0) {

            arr[cx][cy] = cur--;
            if (arr[cx][cy] == target) {
                tx = cx + 1;
                ty = cy + 1;
            }

            int nx = cx + dx[d];
            int ny = cy + dy[d];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] > 0) {
                d = (d + 1) % 4;
            }

            cx += dx[d];
            cy += dy[d];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print(tx + " " + ty);
    }
}
