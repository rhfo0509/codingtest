import java.io.*;

public class Main {
    static int N, s, e, lim, len;
    static char[] arr;
    static int[] cntArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
        cntArr = new int[26];

        cntArr[arr[e] - 'a']++;
        lim = 1;
        len = 1;
        while (s <= e) {
            if (lim <= N) {
                len = Math.max(len, e - s + 1);
                e++;
                if (e == arr.length) break;
                if (++cntArr[arr[e] - 'a'] == 1) {
                    lim++;
                }
            } else {
                if (--cntArr[arr[s] - 'a'] == 0) {
                    lim--;
                }
                s++;
            }
        }
        System.out.print(len);
    }
}