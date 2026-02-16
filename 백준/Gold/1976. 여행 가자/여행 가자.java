import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static List<List<Integer>> graph;
    static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int flag = Integer.parseInt(st.nextToken());
                if (flag == 1 && i < j) {
                    union(i, j);
                }
            }
        }

        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int city = Integer.parseInt(st.nextToken());
            set.add(find(city));
        }

        if (set.size() == 1) {
            System.out.print("YES");
        } else {
            System.out.println("NO");
        }
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    static int find(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
}
