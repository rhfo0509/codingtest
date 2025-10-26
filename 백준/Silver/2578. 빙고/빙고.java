import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int[] rows, cols;
    static int diag1, diag2;
    static int[][] arr;
    static int count, bingoCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        rows = new int[5];
        cols = new int[5];
        diag1 = 0; diag2 = 0;
        arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                count++;
                int n = Integer.parseInt(st.nextToken());
                check(n);
            }
        }
    }

    static void check(int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == n) {

                    rows[i] += 1;
                    if (rows[i] == 5) {
                        bingoCount += 1;
                    }
                    cols[j] += 1;
                    if (cols[j] == 5) {
                        bingoCount += 1;
                    }
                    if (i == j) {
                        diag1 += 1;
                        if (diag1 == 5) {
                            bingoCount += 1;
                        }
                    }
                    if (i + j == 4) {
                        diag2 += 1;
                        if (diag2 == 5) {
                            bingoCount += 1;
                        }
                    }
                    if (bingoCount >= 3) {
                        System.out.print(count);
                        System.exit(0);
                    }
                }
            }
        }
    }
}