import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        int removeIndex = 0;
        int removeCount = 0;

        System.out.print("<");
        while (true) {
            int count = 0;
            while (true) {
                if (arr[removeIndex] != 0) {
                    count += 1;
                    if (count == K) {
                        break;
                    }
                }
                removeIndex = (removeIndex + 1) % N;
            }
            System.out.print(arr[removeIndex]);
            arr[removeIndex] = 0;
            removeCount++;
            if (removeCount == N) {
                break;
            }
            System.out.print(", ");
        }
        System.out.print(">");
    }
}