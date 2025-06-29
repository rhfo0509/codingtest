import java.util.Scanner;

public class Main {
    public static int paint(int i, int j, char[][] board) {
        // k + l -> odd : W / even : B
        int oddWCount = 0;
        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if ((k + l) % 2 != 0 && board[k][l] != 'W') {
                    oddWCount += 1;
                }
                else if ((k + l) % 2 == 0 && board[k][l] != 'B') {
                    oddWCount += 1;
                }
            }
        }
        // k + l -> odd : B / even : W
        int oddBCount = 0;
        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if ((k + l) % 2 != 0 && board[k][l] != 'B') {
                    oddBCount += 1;
                }
                else if ((k + l) % 2 == 0 && board[k][l] != 'W') {
                    oddBCount += 1;
                }
            }
        }
        return Math.min(oddWCount, oddBCount);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        int result = N * M;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                result = Math.min(result, paint(i, j, board));
            }
        }
        System.out.print(result);
    }
}