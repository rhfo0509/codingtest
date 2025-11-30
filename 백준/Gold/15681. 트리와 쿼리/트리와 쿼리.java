import java.io.*;
import java.util.*;

public class Main {
    static int N, R, Q;
    static List<List<Integer>> graph;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        size = new int[N + 1];
        Arrays.fill(size, 1);
        size[R] = dfs(-1, R);
        for (int i = 0; i < Q; i++) {
            System.out.println(size[Integer.parseInt(br.readLine())]);
        }
    }
    static int dfs(int parent, int cur) {
        for (int next : graph.get(cur)) {
            if (next != parent) size[cur] += dfs(cur, next);
        }
        return size[cur];
    }
}