import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String[] tokens = sc.nextLine().split(" ");
        int[] numArr = new int[N];
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(tokens[i]);
        }
        int result = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = numArr[i] + numArr[j] + numArr[k];
                    if (sum > M) {
                        continue;
                    }
                    result = Math.max(result, sum);
                }
            }
        }
        System.out.print(result);
    }
}