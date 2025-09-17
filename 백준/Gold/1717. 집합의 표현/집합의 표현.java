import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int px = find(x);
            int py = find(y);
            if (cmd == 0) {
                union(px, py);
            } else {
                if (px == py) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.print(sb);
    }

    private static int find(int x) {
        if (parent[x] == x) return parent[x];
        else return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }
}