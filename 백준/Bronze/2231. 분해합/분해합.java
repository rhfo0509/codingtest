import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        for (int i = 1; i < N; i++) {
            String strN = String.valueOf(i);
            int sum = i;
            for (int j = 0; j < strN.length(); j++) {
                sum += strN.charAt(j) - '0';
            }
            if (sum == N) {
                result = i;
                break;
            }
        }
        System.out.print(result);
    }
}