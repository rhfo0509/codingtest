import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int Y = sc.nextInt();

        int result = 1;
        int remainingHeight = Y - A;
        if (remainingHeight % (A - B) != 0) {
            result += 1;
        }
        result += remainingHeight / (A - B);

        System.out.println(result);
    }
}