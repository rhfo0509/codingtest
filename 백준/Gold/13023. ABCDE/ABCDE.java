import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<List<Integer>> arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, 1);
        }

        System.out.println(0);
    }

    private static void dfs(int start, int count) {
        if (count == 5) {
            System.out.println(1);
            System.exit(0);
        }

        for (Integer i : arr.get(start)) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, count + 1);
                visited[i] = false;
            }
        }
    }
}
