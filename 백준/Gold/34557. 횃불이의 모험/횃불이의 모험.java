import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M, x, y;
    static int[][] arr;
    static char[] keyList = {'W', 'A', 'S', 'D'};
    static boolean[] prevFlag, curFlag; // 직전 이벤트 상태, 현재 이벤트 상태
    static HashMap<Character, String> map;

    static Deque<int[]> dq;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        map = new HashMap<>();
        map.put('W', br.readLine());
        map.put('A', br.readLine());
        map.put('S', br.readLine());
        map.put('D', br.readLine());

        prevFlag = new boolean[N];
        curFlag = new boolean[N];
        String cmd = br.readLine();
        for (int i = 0; i < M; i++) {
            char c = cmd.charAt(i);

            // 키를 눌렀는지에 대한 상태를 갱신한다.
            for (int k = 0; k < 4; k++) {
                prevFlag[k] = curFlag[k];
                curFlag[k] = (keyList[k] == c);
            }

            for (int k = 0; k < 4; k++) {
                String event = "None";
                if (!prevFlag[k] && curFlag[k]) event = "Down";
                else if (prevFlag[k] && curFlag[k]) event = "Stay";
                else if (prevFlag[k] && !curFlag[k]) event = "Up";

                if (event.equals(map.get(keyList[k]))) {
                    move(x, y, k);
                }
            }
        }

        System.out.print((x + 1) + " " + (y + 1));
    }

    static void move(int cx, int cy, int d) {
        int nx = cx + dx[d];
        int ny = cy + dy[d];

        if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] == 1) {
            return;
        }

        arr[cx][cy] = 0;
        arr[nx][ny] = 2;
        x = nx;
        y = ny;
    }
}
