import java.io.*;
import java.util.*;
public class Main {
    static int n, diameter;
    static List<List<Edge>> graph;
    static class Edge {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static boolean[] visited, isLeafNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        isLeafNode = new boolean[n + 1];
        Arrays.fill(isLeafNode, true);
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, weight));
            graph.get(to).add(new Edge(from, weight));
            isLeafNode[from] = false;
        }

        diameter = 0;
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            // 리프 노드인 경우 지름의 끝 지점이 될 수 있다.
            if (isLeafNode[i]) {
                visited[i] = true;
                dfs(i, 0);
            }
        }
        System.out.print(diameter);
    }
    static void dfs(int cur, int length) {
        diameter = Math.max(diameter, length);
        for (Edge e : graph.get(cur)) {
            if (!visited[e.to]) {
                visited[e.to] = true;
                dfs(e.to, length + e.weight);
                visited[e.to] = false;
            }
        }
    }
}