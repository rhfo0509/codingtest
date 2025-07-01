import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        for (int i = 0; i < P; i++) {
            int T = sc.nextInt();
            int[] arr = new int[20];
            for (int j = 0; j < 20; j++) {
                arr[j] = sc.nextInt();
            }
            int result = 0;
            for (int j = 0; j < 20; j++) {
                int curNum = arr[j];
                for (int k = j - 1; k >= 0; k--) {
                    if (arr[k] > curNum) {
                        result += 1;
                    }
                }
            }
            System.out.println(T + " " + result);
        }
    }
}