import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static String str;
    static int M;
    static Deque<String> q1 = new ArrayDeque<>();
    static Deque<String> q2 = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            q1.push(str.charAt(i) + "");
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("P")) {
                q1.push(st.nextToken());
            }
            else if (cmd.equals("L") && !q1.isEmpty()) {
                q2.push(q1.pop());
            }
            else if (cmd.equals("D") && !q2.isEmpty()) {
                q1.push(q2.pop());
            }
            else if (cmd.equals("B") && !q1.isEmpty()) {
                q1.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q1.isEmpty()) {
            sb.append(q1.pollLast());
        }
        while (!q2.isEmpty()) {
            sb.append(q2.pop());
        }
        System.out.print(sb);
    }
}
