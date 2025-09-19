import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        int maxH = 0;
        int left = -1, right = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            maxH = Math.max(maxH, H);

            arr[i][0] = L;
            arr[i][1] = H;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int curL = 0;
        int curH = 0;

        int totalArea = 0;

        for (int i = 0; i < N; i++) {
            if (curH < arr[i][1]) {
                totalArea += (arr[i][0] - curL) * curH;

                if (arr[i][1] == maxH) {
                    curL = 1001;
                    curH = 0;
                    left = i;
                    break;
                }
                curL = arr[i][0];
                curH = arr[i][1];
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if (curH < arr[i][1]) {
                totalArea += (curL - arr[i][0]) * curH;

                if (arr[i][1] == maxH) {
                    right = i;
                    break;
                }
                curL = arr[i][0];
                curH = arr[i][1];
            }
        }

        totalArea += maxH * (arr[right][0] - arr[left][0] + 1);
        System.out.print(totalArea);
    }
}