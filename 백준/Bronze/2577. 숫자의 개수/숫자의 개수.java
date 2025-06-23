import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 1;
        for (int i = 0; i < 3; i++) {
            sum *= sc.nextInt();
        }
        String sumStr = String.valueOf(sum);
        int[] numArr = new int[10];
        for (int i = 0; i < sumStr.length(); i++) {
            char c = sumStr.charAt(i);
            numArr[c - '0'] += 1;
        }
        for (int n : numArr) {
            System.out.println(n);
        }
    }
}