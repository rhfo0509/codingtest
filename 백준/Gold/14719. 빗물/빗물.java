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
        int[] lMaxH = new int[W];
        int[] rMaxH = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (i == 0) lMaxH[i] = arr[i];
            else lMaxH[i] = Math.max(lMaxH[i - 1], arr[i]);
        }

        for (int i = W - 1; i >= 0; i--) {
            if (i == W - 1) rMaxH[i] = arr[i];
            else rMaxH[i] = Math.max(rMaxH[i + 1], arr[i]);
        }

        // 총 쌓인 빗물의 양
        int result = 0;
        for (int i = 0; i < W; i++) {
            int h = arr[i];
            int maxH = Math.min(lMaxH[i], rMaxH[i]);
            if (h < maxH) result += maxH - h;
        }

        System.out.println(result);
    }
}