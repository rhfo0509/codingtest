import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static double E, cost;
    static int[] posX, posY;
    static List<Edge> arr;

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        double weight;
        public Edge(int x, int y, double weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(weight, o.weight);
        }
    }

    // Union-Find
    static int[] parent;

    static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }
    
    static void union(int x, int y) {

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            posX = new int[N];
            posY = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                posX[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                posY[i] = Integer.parseInt(st.nextToken());
            }
            E = Double.parseDouble(br.readLine());

            arr = new ArrayList<Edge>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    long width = Math.abs(posX[i] - posX[j]);
                    long height = Math.abs(posY[i] - posY[j]);
                    long L = (width * width) + (height * height);

                    arr.add(new Edge(i, j, E * L));
                }
            }
            Collections.sort(arr);

            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            int count = 0;
            double cost = 0.0;
            for (Edge edge : arr) {
                int parentX = findParent(edge.x);
                int parentY = findParent(edge.y);

                if (parentX == parentY) continue;

                union(parentX, parentY);

                count += 1;
                cost += edge.weight;
                if (count == N - 1) {
                    break;
                }
            }

            System.out.printf("#%d %d\n", tc, Math.round(cost));
        }
    }
}