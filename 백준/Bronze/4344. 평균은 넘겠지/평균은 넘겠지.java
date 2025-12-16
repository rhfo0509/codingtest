import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int C = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= C; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int sum = 0;
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            double avg = (double) sum / N;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (avg < arr[i]) {
                    cnt++;
                }
            }
            System.out.printf("%.3f", (double) cnt / N * 100);
            System.out.println("%");
        }
    }
}