import java.io.*;
public class Main {
    static int G, P, count;
    static boolean[] airport;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        airport = new boolean[G + 1];
        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int pos = parent[g];
            while (pos > 0) {
                if (!airport[pos]) break;
                pos--;
            }
            if (pos == 0) break;
            airport[pos] = true;
            parent[g] = --pos;
            count++;
        }
        System.out.print(count);
    }
}