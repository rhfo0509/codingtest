import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        while (deque.size() != 1) {
            deque.removeFirst();
            deque.add(deque.removeFirst());
        }
        System.out.print(deque.removeFirst());
    }
}