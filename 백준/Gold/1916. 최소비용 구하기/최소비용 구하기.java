import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge {
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static class Node implements Comparable<Node> {
		int to;
		int dist;
		
		public Node(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
	static int N, M;
	static List<List<Edge>> arr;
	static int[] distance;
	static int fromIndex, toIndex;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr.get(a).add(new Edge(b, c));
		}
		
		distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		st = new StringTokenizer(br.readLine());
		fromIndex = Integer.parseInt(st.nextToken());
		toIndex = Integer.parseInt(st.nextToken());
		
		dijkstra();
		
		System.out.println(distance[toIndex]);
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(fromIndex, 0));
		distance[fromIndex] = 0;
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (node.dist > distance[node.to]) continue;
			
			for (Edge edge : arr.get(node.to)) {
				if (distance[node.to] + edge.weight < distance[edge.to]) {
					distance[edge.to] = distance[node.to] + edge.weight;
					pq.offer(new Node(edge.to, distance[edge.to]));
				}
			}
		}
	}

}