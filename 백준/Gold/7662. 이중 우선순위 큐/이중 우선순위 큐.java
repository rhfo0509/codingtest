import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int k;
    static TreeMap<Integer, Integer> dpq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            k = Integer.parseInt(br.readLine());
            dpq = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                String cmd = st.nextToken();
                if (cmd.equals("I")) {
                    int n = Integer.parseInt(st.nextToken());
                    dpq.put(n, dpq.getOrDefault(n, 0) + 1);
                } else {
                    int op = Integer.parseInt(st.nextToken());
                    if (!dpq.isEmpty()) {
                        int key;
                        if (op == -1) {
                            key = dpq.firstKey();
                        } else {
                            key = dpq.lastKey();
                        }
                        dpq.put(key, dpq.get(key) - 1);
                        if (dpq.get(key) == 0) {
                            dpq.remove(key);
                        }
                    }
                }
            }

            if (dpq.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(dpq.lastKey() + " " + dpq.firstKey());
            }
        }
    }
}