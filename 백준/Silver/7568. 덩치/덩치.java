import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int[] result = new int[n];
        Arrays.fill(result, 1);
        for (int i = 0; i < n; i++) {
            int weight = arr[i][0];
            int height = arr[i][1];
            for (int j = 0; j < n; j++) {
                if (weight < arr[j][0] && height < arr[j][1]) {
                    result[i] += 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}