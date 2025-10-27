import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static String W;
    static int K;
    static int[] countArr;
    static List<List<Integer>> idxArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            W = br.readLine();
            K = Integer.parseInt(br.readLine());

            // K가 1이면
            // 1 1을 출력하고 break
            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            countArr = new int[26];

            // prevEnd: 직전의 end값
            int start = 0, end = 0, prevEnd = -1;

            // res1: 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이
            // res2: 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이
            int res1 = Integer.MAX_VALUE, res2 = 0;

            while (start <= end && end < W.length()) {
                int i = W.charAt(end) - 'a';
                if (prevEnd != end) countArr[i] += 1;
                prevEnd = end;
                if (countArr[i] == K) {
                    res1 = Math.min(res1, end - start + 1);
                    int j = W.charAt(start) - 'a';
                    countArr[j] -= 1;
                    start++;
                } else {
                    end++;
                }
            }

            idxArr = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                idxArr.add(new ArrayList<>());
            }
            for (int i = 0; i < W.length(); i++) {
                int idx = W.charAt(i) - 'a';
                idxArr.get(idx).add(i);
            }
            for (int i = 0; i < 26; i++) {
                List<Integer> temp = idxArr.get(i);
                int size = temp.size();
                if (size < K) continue;
                for (int j = 0; j <= size - K; j++) {
                    int s = temp.get(j);
                    int e = temp.get(j + K - 1);
                    res2 = Math.max(res2, e - s + 1);
                }
            }

            if (res1 == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(res1 + " " + res2);
            }
        }
    }
}