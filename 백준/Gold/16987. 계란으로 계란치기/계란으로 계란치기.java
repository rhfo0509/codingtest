import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    // {내구도, 무게}
    static int[][] eggs;
    static int result;

    static void dfs(int idx) {
        if (idx == N) {
            int eggCount = 0;
            for (int i = 0; i < N; i++) {
                if (eggs[i][0] <= 0) eggCount++;
            }
            result = Math.max(result, eggCount);
            return;
        }

        boolean hit = false;
        for (int i = 0; i < N; i++) {
            if (i == idx) continue;

            if (eggs[i][0] <= 0 || eggs[idx][0] <= 0) {
                continue;
            }

            hit = true;
            eggs[i][0] -= eggs[idx][1];
            eggs[idx][0] -= eggs[i][1];

            dfs(idx + 1);

            eggs[i][0] += eggs[idx][1];
            eggs[idx][0] += eggs[i][1];
        }

        if (!hit) dfs(idx + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            eggs[i][0] = S;
            eggs[i][1] = W;
        }

        result = 0;
        if (N != 1) {
            dfs(0);

        }
        System.out.println(result);
    }
}
