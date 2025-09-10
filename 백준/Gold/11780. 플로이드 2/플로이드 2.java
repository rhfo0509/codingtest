import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n + 1][n + 1];
        int[][] nxt = new int[n + 1][n + 1];

        List<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], 100_000_001);
            graph[i][i] = 0;
            Arrays.fill(nxt[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], c);
            nxt[a][b] = b;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        nxt[i][j] = nxt[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 100_000_001) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (nxt[i][j] == Integer.MAX_VALUE) {
                    System.out.print(0);
                } else {
                    arr.clear();
                    int start = i;
                    arr.add(start);
                    while (start != j) {
                        start = nxt[start][j];
                        arr.add(start);
                    }
                    System.out.print(arr.size() + " ");
                    for (Integer num : arr) {
                        System.out.print(num + " ");
                    }
                }
                System.out.println();

            }
        }
    }
}