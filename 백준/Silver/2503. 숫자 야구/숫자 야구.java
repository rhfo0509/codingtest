import java.io.*;
import java.util.*;

public class Main {
    static int N, count;
    static int[] numArr;
    static boolean[] visited;
    static class NumInfo {
        String num;
        int strike;
        int ball;
        NumInfo(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
    static NumInfo[] numInfos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        numInfos = new NumInfo[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            numInfos[i] = new NumInfo(num, strike, ball);
        }

        numArr = new int[3];
        visited = new boolean[10];
        count = 0;
        dfs(0);
        System.out.print(count);
    }
    static void dfs(int depth) {
        if (depth == 3) {
            if (numberBasketball()) count++;
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numArr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
    static boolean numberBasketball() {

        for (int i = 0; i < N; i++) {
            int strike = 0;
            int ball = 0;
            for (int j = 0; j < 3; j++) {
                int cur = numInfos[i].num.charAt(j) - '0';
                for (int k = 0; k < 3; k++) {
                    if (numArr[k] == cur) {
                        if (j == k) strike++;
                        else ball++;
                    }
                }
            }
            if (strike != numInfos[i].strike || ball != numInfos[i].ball) return false;
        }

        return true;
    }
}