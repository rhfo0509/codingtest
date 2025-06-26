import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        int[] arr = new int[tokens.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        String status;
        if (arr[0] < arr[1]) {
            status = "ascending";
        } else {
            status = "descending";
        }
        int curValue = arr[1];
        for (int i = 2; i < arr.length; i++) {
            if ((curValue < arr[i] && status.equals("descending")) || curValue > arr[i] && status.equals("ascending")) {
                status = "mixed";
                break;
            }
            curValue = arr[i];
        }
        System.out.print(status);
    }
}