import java.io.*;
import java.util.*;

public class Main {
    static int V, E, res;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        matrix = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            Arrays.fill(matrix[i], 4_000_001);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrix[a][b] = c;
        }
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }

        res = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (matrix[i][j] != 4_000_001 && matrix[j][i] != 4_000_001) {
                    res = Math.min(res, matrix[i][j] + matrix[j][i]);
                }
            }
        }

        if (res == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(res);
        }
    }
}