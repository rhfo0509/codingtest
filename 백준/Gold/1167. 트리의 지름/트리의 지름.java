import java.io.*;
import java.util.*;
public class Main {
    static int V, maxLength;
    static class Edge {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static List<List<Edge>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                graph.get(from).add(new Edge(to, weight));
            }
        }
        maxLength = 0;
        visited = new boolean[V + 1];
        visited[1] = true;
        dfs(1);
        System.out.print(maxLength);
    }
    static int dfs(int cur) {

        // 해당 정점에서 아래로 쭉 내려가는 가장 긴 길이
        int max1 = 0;
        // 두 번째로 긴 길이
        int max2 = 0;

        for (Edge e : graph.get(cur)) {
            int next = e.to;
            if (visited[next]) continue;
            visited[next] = true;

            int w = e.weight;
            int length = w + dfs(next);

            if (length > max1) {
                max2 = max1;
                max1 = length;
            }
            else if (length > max2) {
                max2 = length;
            }
        }

        maxLength = Math.max(maxLength, max1 + max2);

        // 부모에게 넘겨줄 때는 최대 길이만 넘겨주면 됨 (트리 DP)
        return max1;
    }
}