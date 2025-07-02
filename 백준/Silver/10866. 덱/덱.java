import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push_front")) {
                dq.offerFirst(Integer.parseInt(cmd[1]));
            } else if (cmd[0].equals("push_back")) {
                dq.offer(Integer.parseInt(cmd[1]));
            } else if (cmd[0].equals("pop_front")) {
                Integer num = dq.poll();
                if (num == null) {
                    System.out.println(-1);
                } else {
                    System.out.println(num);
                }
            } else if (cmd[0].equals("pop_back")) {
                Integer num = dq.pollLast();
                if (num == null) {
                    System.out.println(-1);
                } else {
                    System.out.println(num);
                }
            } else if (cmd[0].equals("size")) {
                System.out.println(dq.size());
            } else if (cmd[0].equals("empty")) {
                if (dq.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (cmd[0].equals("front")) {
                Integer num = dq.peek();
                if (num == null) {
                    System.out.println(-1);
                } else {
                    System.out.println(num);
                }
            } else if (cmd[0].equals("back")) {
                Integer num = dq.peekLast();
                if (num == null) {
                    System.out.println(-1);
                } else {
                    System.out.println(num);
                }
            }
        }
    }
}