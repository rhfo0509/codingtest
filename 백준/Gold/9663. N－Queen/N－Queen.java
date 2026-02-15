import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt;
    static boolean[] row, col, diag1, diag2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        row = new boolean[N];
        col = new boolean[N];
        diag1 = new boolean[2 * N - 1];
        diag2 = new boolean[2 * N - 1];
        backtracking(0);
        System.out.print(cnt);
    }
    static void backtracking(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (col[i]) continue;
            if (diag1[depth - i + N - 1]) continue;
            if (diag2[depth + i]) continue;
            col[i] = true;
            diag1[depth - i + N - 1] = true;
            diag2[depth + i] = true;
            backtracking(depth + 1);
            col[i] = false;
            diag1[depth - i + N - 1] = false;
            diag2[depth + i] = false;
        }
    }
}
