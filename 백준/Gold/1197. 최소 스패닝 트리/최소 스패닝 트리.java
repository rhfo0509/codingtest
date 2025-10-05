import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E;
    static int[] parent;
    static List<Edge> graph;
    static int count, result;

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        graph = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.add(new Edge(A, B, C));
        }

        // 가중치가 작은 순서로 정렬
        Collections.sort(graph);

        count = 0;
        result = 0;
        for (int i = 0; i < E; i++) {
            Edge cur = graph.get(i);

            int a = cur.from;
            int b = cur.to;
            int c = cur.cost;

            int parentA = find(a);
            int parentB = find(b);

            if (parentA != parentB) {
                union(parentA, parentB);
                count += 1;
                result += c;
            }

            if (count == V - 1) {
                break;
            }
        }

        System.out.print(result);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
