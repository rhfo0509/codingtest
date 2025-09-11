import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        bfs(n);
    }

    private static void bfs(int n) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        q.offer(new int[] {n, 0});
        visited[n] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int pn = p[0];
            int pc = p[1];
            if (pn == 0) {
                System.out.println(pc);
                return;
            }
            for (int i = (int) Math.floor(Math.sqrt(pn)); i >= 1; i--) {
                int nn = pn - (i * i);
                if (!visited[nn]) {
                    visited[nn] = true;
                    q.offer(new int[] {nn, pc + 1});
                }
            }
        }
    }
}