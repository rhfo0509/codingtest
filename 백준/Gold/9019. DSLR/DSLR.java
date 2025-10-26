import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Record {
        int num;
        StringBuilder cmd;

        Record(int num, StringBuilder cmd) {
            this.num = num;
            this.cmd = cmd;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bfs(A, B);
        }
    }

    static void bfs(int a, int b) {
        Deque<Record> q = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];

        q.offer(new Record(a, new StringBuilder()));
        visited[a] = true;

        while (!q.isEmpty()) {
            Record r = q.poll();
            if (r.num == b) {
                System.out.println(r.cmd);
                break;
            }

            // 1. L
            int num = (r.num % 1000) * 10 + r.num / 1000;
            if (!visited[num]) {
                q.offer(new Record(num, new StringBuilder(r.cmd).append("L")));
                visited[num] = true;
            }
            
            // 2. R
            num = (r.num % 10) * 1000 + r.num / 10;
            if (!visited[num]) {
                q.offer(new Record(num, new StringBuilder(r.cmd).append("R")));
                visited[num] = true;
            }
            
            // 3. D
            num = (r.num * 2) % 10000;
            if (!visited[num]) {
                q.offer(new Record(num, new StringBuilder(r.cmd).append("D")));
                visited[num] = true;
            }
            
            // 4. S
            num = r.num - 1;
            if (r.num == 0) num = 9999;
            if (!visited[num]) {
                q.offer(new Record(num, new StringBuilder(r.cmd).append("S")));
                visited[num] = true;
            }
        }
    }
}
