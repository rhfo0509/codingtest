import java.io.*;
import java.util.*;
public class Main {
    static int L;
    static Deque<Character> q1, q2;
    static char[] keys;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringBuilder sb = new StringBuilder();
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
            keys = br.readLine().toCharArray();
            for (char key : keys) {
                if (key == '<') {
                    if (!q1.isEmpty()) {
                        q2.push(q1.pop());
                    }
                } else if (key == '>') {
                    if (!q2.isEmpty()) {
                        q1.push(q2.pop());
                    }
                } else if (key == '-') {
                    if (!q1.isEmpty()) {
                        q1.pop();
                    }
                } else {
                    q1.push(key);
                }
            }
            while (!q1.isEmpty()) {
                sb.append(q1.pop());
            }
            sb.reverse();
            while (!q2.isEmpty()) {
                sb.append(q2.pop());
            }
            System.out.println(sb);
        }
    }
}