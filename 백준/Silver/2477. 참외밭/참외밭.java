import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int K, mxw, mxh, mnw, mnh;
    static Deque<Tlqkf> q;
    static class Tlqkf {
        int dir;
        int length;
        Tlqkf(int dir, int length) {
            this.dir = dir;
            this.length = length;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        q = new ArrayDeque<>();
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            q.offer(new Tlqkf(dir, length));
        }
        // 1. 우선 큰 사각형의 가로 세로를 구한다.
        for (int i = 0; i < 6; i++) {
            Tlqkf tlqkf = q.poll();
            if (tlqkf.dir == 1 || tlqkf.dir == 2) {
                mxw = Math.max(mxw, tlqkf.length);
            } else {
                mxh = Math.max(mxh, tlqkf.length);
            }
            q.offer(tlqkf);
        }
        // 2. 3 1 3 1 >> 같은 패턴이 나올 때까지 큐에서 요소를 꺼내고 삽입하는 과정을 반복한다.

        Tlqkf t1 = new Tlqkf(-1, 0);
        Tlqkf t2 = new Tlqkf(-2, 0);
        Tlqkf t3 = new Tlqkf(-3, 0);
        Tlqkf t4 = new Tlqkf(-4, 0);

        while (true) {
            if (t1.dir == t3.dir && t2.dir == t4.dir) {
                mnw = t2.length;
                mnh = t3.length;
                break;
            } else {
                t1 = t2;
                t2 = t3;
                t3 = t4;
                t4 = q.poll();
                q.offer(t4);
            }
        }

        System.out.print(((mxw * mxh) - (mnw * mnh)) * K);
    }
}
