import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    static int N;
    static List<Long> arr;
    static BigInteger bi = new BigInteger("9876543210");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for (long i = 0; i <= 9; i++) {
            arr.add(i);
            dfs(i);
        }
        Collections.sort(arr);
        if (N >= arr.size()) System.out.print(-1);
        else System.out.print(arr.get(N));
    }
    static void dfs(long cur) {
        String str = "" + cur;
        int last = str.charAt(str.length() - 1) - '0';
        for (int i = 0; i < 9; i++) {
            if (last <= i) break;
            long next = cur * 10 + i;
            if (next > bi.longValue()) break;
            arr.add(next);
            dfs(next);
        }
    }
}