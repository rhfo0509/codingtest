import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] A;
    static ArrayList<ArrayList<String>> result;
    public static int[][] turn() {
        int[][] newArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder("");
            for (int j = 0; j < N; j++) {
                newArr[i][j] = A[N - j - 1][i];
                sb.append(newArr[i][j]);
            }
            result.get(i).add(sb.toString());
        }
        return newArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            A = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                result.add(new ArrayList<>());
            }
            for (int i = 0; i < 3; i++) {
                A = turn();
            }
            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(result.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}