import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
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