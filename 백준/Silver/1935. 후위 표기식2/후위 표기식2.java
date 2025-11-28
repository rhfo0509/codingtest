import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[] expr;
    static double[] val;
    static Deque<Double> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        expr = br.readLine().toCharArray();
        val = new double[N];
        for (int i = 0; i < N; i++) {
            val[i] = Integer.parseInt(br.readLine());
        }
        q = new ArrayDeque<>();
        for (int i = 0; i < expr.length; i++) {
            char cur = expr[i];
            if (q.isEmpty() || (cur >= 'A' && cur <= 'Z')) {
                q.push(val[cur - 'A']);
            } else {
                double t1, t2;
                t1 = q.pop();
                t2 = q.pop();
                if (cur == '+') q.push(t2 + t1);
                else if (cur == '-') q.push(t2 - t1);
                else if (cur == '*') q.push(t2 * t1);
                else q.push(t2 / t1);
            }
        }
        System.out.printf("%.2f", q.pop());
    }
}