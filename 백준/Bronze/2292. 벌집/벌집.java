import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int curValue = 1;
        int step = 6;
        int result = 1;
        while (true) {
            if (curValue >= N) {
                break;
            }
            curValue += step;
            step += 6;
            result += 1;
        }
        System.out.print(result);
    }
}