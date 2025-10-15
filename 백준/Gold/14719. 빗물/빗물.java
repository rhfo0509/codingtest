import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 총 쌓인 빗물의 양
        int result = 0;
        for (int i = 0; i < W; i++) {

            int lMaxH = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                lMaxH = Math.max(lMaxH, arr[j]);
            }

            int rMaxH = arr[i];
            for (int j = i + 1; j < W; j++) {
                rMaxH = Math.max(rMaxH, arr[j]);
            }

            int maxH = Math.min(lMaxH, rMaxH);
            if (maxH > arr[i]) result += maxH - arr[i];
        }

        System.out.println(result);
    }
}