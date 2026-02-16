import java.io.*;
import java.util.*;

public class Main {
    static int N, c1, c2, c3;
    static int[][] matrix;
    static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, N);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
    static void recur(int x, int y, int n) {
        set = new HashSet<>();
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                set.add(matrix[i][j]);
            }
        }
        if (set.size() == 1) {
            if (set.contains(-1)) c1++;
            else if (set.contains(0)) c2++;
            else c3++;
        } else {
            recur(x, y, n / 3);
            recur(n / 3 + x, y, n / 3);
            recur(2 * n / 3 + x, y, n / 3);
            recur(x, n / 3 + y, n / 3);
            recur(n / 3 + x, n / 3 + y, n / 3);
            recur(2 * n / 3 + x, n / 3 + y, n / 3);
            recur(x, 2 * n / 3 + y, n / 3);
            recur(n / 3 + x, 2 * n / 3 + y, n / 3);
            recur(2 * n / 3 + x, 2 * n / 3 + y, n / 3);
        }
    }
}