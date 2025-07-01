import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 5 == 0) {
                // i!의 뒤에서부터 최초로 0이 아닌 숫자는 반드시 2의 배수
                result += 1;
            }
            if (i % 25 == 0) {
                // i!의 뒤에서부터 최초로 0이 아닌 숫자는 반드시 4의 배수
                result += 1;
            }
            if (i % 125 == 0) {
                // i!의 뒤에서부터 최초로 0이 아닌 숫자는 반드시 8의 배수
                // ex) 125의 경우 -> 122 * 124에 의해 8의 배수가 됨
                result += 1;
            }
        }
        System.out.print(result);
    }
}