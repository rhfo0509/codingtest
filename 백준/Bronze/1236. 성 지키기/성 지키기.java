import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count;
    static char[][] arr;
    static boolean[] r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        r = new boolean[N];
        c = new boolean[M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
            for (int j = 0;  j < M; j++) {
                if (arr[i][j] == 'X') {
                    r[i] = true;
                    c[j] = true;
                }
            }
        }
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!r[i] && !c[j]) {
                    r[i] = true;
                    c[j] = true;
                    count++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (!r[i]) count++;
        }
        for (int j = 0; j < M; j++) {
            if (!c[j]) count++;
        }
        System.out.print(count);
    }
}