import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String blanks = " ".repeat(i);
            String stars = "*".repeat(2 * (n - i) - 1);
            System.out.println(blanks + stars);
        }
        for (int i = n - 2; i >= 0; i--) {
            String blanks = " ".repeat(i);
            String stars = "*".repeat(2 * (n - i) - 1);
            System.out.println(blanks + stars);
        }
    }
}