import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        for (int i = 0; i < 3; i++) {
            String s = sc.nextLine();
            if (s.charAt(0) != 'F' && s.charAt(0) != 'B') {
                num = Integer.parseInt(s) + (3 - i);
            }
        }
        if (num % 15 == 0) {
            System.out.print("FizzBuzz");
        } else if (num % 3 == 0) {
            System.out.print("Fizz");
        } else if (num % 5 == 0) {
            System.out.print("Buzz");
        } else {
            System.out.print(num);
        }
    }
}