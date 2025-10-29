import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] distance;
    static List<List<Edge>> arr;

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int totalDistance;

        Node(int to, int totalDistance) {
            this.to = to;
            this.totalDistance = totalDistance;
        }

        @Override
        public int compareTo(Node o) {
            return totalDistance - o.totalDistance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) { 
        	st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            arr.get(A).add(new Edge(B, C));
            arr.get(B).add(new Edge(A, C));
        }

        dijkstra();
        System.out.print(distance[N]);
    }

    static void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
        	Node node = pq.poll();
        	if (distance[node.to] < node.totalDistance) {
        		continue;
        	}
        	for (Edge next : arr.get(node.to)) {
        		if (distance[next.to] > node.totalDistance + next.cost) {
        			distance[next.to] = node.totalDistance + next.cost;
        			pq.offer(new Node(next.to, distance[next.to]));
        		}
        	}
        }
    }
}