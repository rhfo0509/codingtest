import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        int res1 = arr[0] + arr[1] - arr[2];
        int res2 = Integer.valueOf(String.valueOf(arr[0]).concat(String.valueOf(arr[1]))) - arr[2];
        System.out.println(res1);
        System.out.println(res2);
    }
}