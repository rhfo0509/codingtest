import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

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
    static int V, E;
    static List<List<Edge>> arr;
    static int[] mVisited, sVisited;

    static int M, x;
    static int S, y;

    static PriorityQueue<Edge> pq;
    static HashSet<Integer> set;
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr.get(u).add(new Edge(v, w));
            arr.get(v).add(new Edge(u, w));
        }

        pq = new PriorityQueue<>();
        set = new HashSet<>();

        // 맥도날드의 수 M, 맥세권일 조건 x
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        // 모든 맥도날드 지점을 다익스트라의 출발점으로 넣는다.
        mVisited = new int[V + 1];
        Arrays.fill(mVisited, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int mNum = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(mNum, 0));
            mVisited[mNum] = 0;
            set.add(mNum);
        }
        dijkstra(mVisited);

        // 스타벅스의 수 S, 스세권일 조건 y
        st =  new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        // 모든 스타벅스 지점을 다익스트라의 출발점으로 넣는다.
        sVisited = new int[V + 1];
        Arrays.fill(sVisited, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            int sNum = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(sNum, 0));
            sVisited[sNum] = 0;
            set.add(sNum);
        }
        dijkstra(sVisited);

        for (int i = 1; i <= V; i++) {
            if (mVisited[i] <= x && sVisited[i] <= y && !set.contains(i)) {
                minDistance = Math.min(minDistance, mVisited[i] + sVisited[i]);
            }
        }

        if (minDistance == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDistance);
        }
    }

    private static void dijkstra(int[] visited) {
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (current.weight > visited[current.to]) continue;

            for (Edge next : arr.get(current.to)) {
                int newWeight = visited[current.to] + next.weight;

                if (visited[next.to] > newWeight) {
                    visited[next.to] = newWeight;
                    pq.offer(new Edge(next.to, newWeight));
                }
            }
        }
    }
}