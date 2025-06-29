import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int minNum = Math.min(A, B);

        int gcd = 0;
        int lcm = 0;
        for (int i = minNum; i > 0; i--) {
            if (A % i == 0 && B % i == 0) {
                gcd = i;
                break;
            }
        }
        int i = 1;
        while (true) {
            int j = minNum * i;
            if (j % A == 0 && j % B == 0) {
                lcm = j;
                break;
            }
            i += 1;
        }
        System.out.printf("%d\n%d", gcd, lcm);
    }
}