import java.io.*;
import java.util.*;
public class Main {
    static int N, K, room;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[2][7];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            arr[S][Y] += 1;
        }
        room = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= 6; j++) {
                if (arr[i][j] / K == 0 && arr[i][j] % K != 0) {
                    room += 1;
                } else if (arr[i][j] % K == 0) {
                    room += arr[i][j] / K;
                } else {
                    room += arr[i][j] / K + 1;
                }
            }
        }
        System.out.print(room);
    }
}