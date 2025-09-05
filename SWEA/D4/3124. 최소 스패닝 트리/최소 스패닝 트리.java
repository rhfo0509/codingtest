import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static int V, E;
    static class Edge implements Comparable<Edge>{
        int to;
        int weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }
    static List<List<Edge>> arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            arr = new ArrayList<>();
            for (int i = 0; i < V + 1; i++) {
                arr.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                arr.get(A).add(new Edge(B, C));
                arr.get(B).add(new Edge(A, C));
            }
            
            visited = new boolean[V + 1];

            System.out.printf("#%d %d\n", tc, prim());
        }
    }
    
    private static long prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        long weight = 0;
        int count = 0;

        // 처음 시작점은 1
        visited[1] = true;
        for (Edge edge : arr.get(1)) {
            pq.offer(edge);
        }

        // 꺼낼 때는 가장 가중치가 낮은 간선이 나온다.
        while (!pq.isEmpty() && count < V - 1) {
            Edge edge = pq.poll();

            if (!visited[edge.to]) {
                weight += edge.weight;
                count += 1;
                visited[edge.to] = true;

                for (Edge newEdge : arr.get(edge.to)) {
                    pq.offer(newEdge);
                }
            }
        }

        return weight;
    }
}