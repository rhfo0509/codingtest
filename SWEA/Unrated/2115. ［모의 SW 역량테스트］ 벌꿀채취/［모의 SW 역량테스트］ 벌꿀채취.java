import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static int N, M, C;
    static int[][] arr;
    static List<HoneyPot> potList;
    static int maxHoney;
    static int temp;

    static class HoneyPot {
        int x;
        int y;
        int[] honey;

        HoneyPot(int x, int y, int[] honey) {
            this.x = x;
            this.y = y;
            this.honey = honey;
        }
    }

    static void dfs(int start, int[] honey, int count, int value) {

        if (count > C) return;

        temp = Math.max(temp, value);

        for (int i = start; i < honey.length; i++) {
            dfs(i + 1, honey, count + honey[i], value + (honey[i] * honey[i]));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            potList = new ArrayList<>();
            maxHoney = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int[] honey = new int[M];
                    for (int k = 0; k < M; k++) {
                        honey[k] = arr[i][j + k];
                    }
                    potList.add(new HoneyPot(i, j, honey));
                }
            }

            // DFS -> 벌통은 2개 선택 가능하므로 2중 반복문으로 대체
            for (int i = 0; i < potList.size(); i++) {
                for (int j = i + 1; j < potList.size(); j++) {
                    HoneyPot hp1 = potList.get(i);
                    HoneyPot hp2 = potList.get(j);

                    // 선택한 벌통들에 대해 최대 수익을 계산
                    // hp1과 hp2가 겹치면 제외
                    if (hp1.x == hp2.x && hp2.y < hp1.y + M) continue;

                    int sum = 0;

                    temp = 0;
                    dfs(0, hp1.honey, 0, 0);
                    sum += temp;

                    temp = 0;
                    dfs(0, hp2.honey, 0, 0);
                    sum += temp;

                    if (sum > maxHoney) {
                        maxHoney = sum;
                    }
                }
            }
            System.out.println("#" + tc + " " + maxHoney);
        }


    }
}
