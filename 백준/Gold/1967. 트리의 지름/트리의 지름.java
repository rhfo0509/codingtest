import java.io.*;
import java.util.*;
public class Main {
    static int n, m, diameter;
    static List<List<Edge>> graph;
    static class Edge {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, weight));
            graph.get(to).add(new Edge(from, weight));
        }

        // 루트 노드 1로부터 가장 먼 정점
        m = 1;
        diameter = 0;
        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        diameter = 0;
        visited = new boolean[n + 1];
        visited[m] = true;
        dfs(m, 0);
        System.out.print(diameter);
    }
    static void dfs(int cur, int length) {
        if (diameter < length) {
            diameter = length;
            m = cur;
        }
        for (Edge e : graph.get(cur)) {
            if (!visited[e.to]) {
                visited[e.to] = true;
                dfs(e.to, length + e.weight);
                visited[e.to] = false;
            }
        }
    }
}