import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	static Map<Integer, int[]> map;
	static StringBuilder sb;
	
	public static void search(int root, int node) {

		int[] children = map.get(root);
		
		// 1. 루트노드보다 값이 작은 경우
		if (node < root) {
			// 루트노드의 왼쪽 자식이 없다면
			if (children[0] == 0) {
				children[0] = node;
				map.put(node, new int[2]);
			} 
			// 있다면 왼쪽 자식을 기준으로 search
			else {
				search(children[0], node);
			}
		}
		// 2. 루트노드보다 값이 큰 경우
		else {
			// 루트노드의 오른쪽 자식이 없다면
			if (children[1] == 0) {
				children[1] = node;
				map.put(node, new int[2]);
			} 
			// 있다면 오른쪽 자식을 기준으로 search
			else {
				search(children[1], node);
			}
		}
	}
	
	public static void postOrder(int root) {
		int[] children = map.get(root);
		
		if (children[0] != 0) postOrder(children[0]);
		if (children[1] != 0) postOrder(children[1]);
		sb.append(root).append("\n");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new HashMap<>();
		
		// 루트노드
		int root = Integer.parseInt(br.readLine());
		map.put(root, new int[2]);
		
		String line;
		while ((line = br.readLine()) != null) {
			int node = Integer.parseInt(line);
			search(root, node);
		}
		
		sb = new StringBuilder();
		postOrder(root);
		System.out.print(sb);
	}

}
