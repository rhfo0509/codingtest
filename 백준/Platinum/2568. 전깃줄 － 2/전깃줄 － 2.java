import java.io.*;
import java.util.*;

public class Main {
    static int n, len, cur;
    static int[][] arr;
    static int[] lis, pos;
    static List<Integer> res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (x, y) -> x[0] - y[0]);
        // lis[len]: len+1 부분수열의 마지막 요소에 들어갈 수 있는 가장 큰 값을 기록.
        lis = new int[n];
        lis[0] = arr[0][1];
        // pos[i]: arr[i][1]의 각 요소가 lis의 어디에 위치하는지 인덱스를 기록.
        pos = new int[n];
        pos[0] = 0;

        len = 1;
        for (int i = 1; i < n; i++) {
            if (lis[len - 1] < arr[i][1]) {
                lis[len] = arr[i][1];
                pos[i] = len;
                len++;
            } else {
                int idx = lowerBound(arr[i][1]);
                lis[idx] = arr[i][1];
                pos[i] = idx;
            }
        }

        System.out.println(n - len);
        cur = len - 1;
        res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (pos[i] == cur) {
                cur--;
            } else {
                res.add(arr[i][0]);
            }
        }
        Collections.reverse(res);
        for (int i : res) {
            System.out.println(i);
        }
    }
    static int lowerBound(int target) {
        int start = 0;
        int end = len - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target <= lis[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}