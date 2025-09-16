import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();

        Deque<Character> leftStk = new ArrayDeque<>();
        Deque<Character> rightStk = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            leftStk.offer(str.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("P")) {
                char value = st.nextToken().charAt(0);
                leftStk.offer(value);
            } else if (cmd.equals("B")) {
                if (!leftStk.isEmpty()) leftStk.pollLast();
            } else if (cmd.equals("L")) {
                if (!leftStk.isEmpty()) {
                    char value = leftStk.pollLast();
                    rightStk.offer(value);
                }
            } else {
                if (!rightStk.isEmpty()) {
                    char value = rightStk.pollLast();
                    leftStk.offer(value);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!leftStk.isEmpty()) {
            sb.append(leftStk.poll());
        }
        while(!rightStk.isEmpty()) {
            sb.append(rightStk.pollLast());
        }
        System.out.print(sb);
    }
}