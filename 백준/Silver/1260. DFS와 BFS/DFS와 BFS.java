import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static Deque<Integer> q;
    static boolean[] visited;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[N + 1];
        visited[V] = true;
        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        visited[V] = true;
        bfs(V);
    }
    static void dfs(int start) {
        System.out.print(start + " ");
        for (int to : graph.get(start)) {
            if (!visited[to]) {
                visited[to] = true;
                dfs(to);
            }
        }
    }
    static void bfs(int start) {
        q = new ArrayDeque<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int p = q.poll();
            System.out.print(p + " ");
            for (int to : graph.get(p)) {
                if (!visited[to]) {
                    visited[to] = true;
                    q.offer(to);
                }
            }
        }
    }
}
