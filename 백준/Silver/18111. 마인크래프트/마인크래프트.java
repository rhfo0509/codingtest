import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, B;
    static List<Integer> arr;
    static int minTime, height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int cur = Integer.parseInt(st.nextToken());
                arr.add(cur);
            }
        }

        arr.sort(Collections.reverseOrder());
        int mx = arr.get(0);
        int mn = arr.get(arr.size() - 1);
        minTime = Integer.MAX_VALUE;
        height = 0;
        for (int i = mx; i >= mn; i--) {
            playMinecraft(i);
        }

        System.out.print(minTime + " " + height);
    }

    static void playMinecraft(int h) {
        int blockCount = B;
        int t = 0;
        for (int i = 0; i < arr.size(); i++) {
            int cur = arr.get(i);
            if (cur > h) {
                blockCount += cur - h;
                t += (cur - h) * 2;
            } else if (cur < h) {
                blockCount -= h - cur;
                if (blockCount < 0) return;
                t += h - cur;
            }

            if (t >= minTime) return;
        }

        minTime = t;
        height = h;
    }
}