import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static PriorityQueue<Integer> q1, q2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        q1 = new PriorityQueue<>(Collections.reverseOrder());
        q2 = new PriorityQueue<>();
        q1.offer(Integer.parseInt(br.readLine()));
        sb.append(q1.peek()).append("\n");
        for (int i = 2; i <= N; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (i % 2 == 1) {
                if (cur < q1.peek()) {
                    q1.offer(cur);
                } else {
                    q2.offer(cur);
                    q1.offer(q2.poll());
                }
            } else {
                if (cur < q1.peek()) {
                    q1.offer(cur);
                    q2.offer(q1.poll());
                } else {
                    q2.offer(cur);
                }
            }
            sb.append(q1.peek()).append("\n");
        }
        System.out.print(sb);
    }
}