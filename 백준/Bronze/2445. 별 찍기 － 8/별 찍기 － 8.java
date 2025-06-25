import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            String stars = "*".repeat(i);
            String blanks = " ".repeat(2 * (n - i));
            System.out.println(stars + blanks + stars);
        }
        for (int i = n - 1; i >= 1; i--) {
            String stars = "*".repeat(i);
            String blanks = " ".repeat(2 * (n - i));
            System.out.println(stars + blanks + stars);
        }
    }
}