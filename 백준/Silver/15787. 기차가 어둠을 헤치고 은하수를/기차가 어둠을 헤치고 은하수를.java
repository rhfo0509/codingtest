import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[] train;
    static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        train = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            b--;
            switch (a) {
                case 1: {
                    int c = Integer.parseInt(st.nextToken());
                    train[b] |= 1 << (c - 1);
                    break;
                }
                case 2: {
                    int c = Integer.parseInt(st.nextToken());
                    train[b] &= ~(1 << (c - 1));
                    break;
                }
                case 3: {
                    train[b] &= ~(1 << 19);
                    train[b] <<= 1;
                    break;
                }
                case 4:
                    train[b] >>= 1;
                    break;
            }
        }
        set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(train[i]);
        }
        System.out.print(set.size());
    }
}