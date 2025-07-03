import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int X = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        // 현재 방문자 수
        int curVisitor = 0;
        for (int i = 0; i < X; i++) {
            curVisitor += arr[i];
        }

        // 최대 방문자 수
        int maxVisitor = curVisitor;
        // 기간
        int day = 1;
        for (int i = 1; i <= N - X; i++) {
            curVisitor -= arr[i - 1];
            curVisitor += arr[i + X - 1];
            if (curVisitor > maxVisitor) {
                maxVisitor = curVisitor;
                day = 1;
            } else if (curVisitor == maxVisitor) {
                day += 1;
            }
        }
        if (maxVisitor == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitor);
            System.out.println(day);
        }
    }
}