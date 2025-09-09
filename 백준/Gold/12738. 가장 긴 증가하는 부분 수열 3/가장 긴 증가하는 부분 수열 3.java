import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr, greedy;
    static int maxLength;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        greedy = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        greedy[0] = arr[0];
        maxLength = 1;

        for (int i = 1; i < N; i++) {
            int lastIndex = maxLength - 1;

            if (arr[i] > greedy[lastIndex]) {
                greedy[maxLength] = arr[i];
                maxLength += 1;
            } else {
                // 이분탐색 (lower-bound)
                // arr[i] 이상의 값이 처음으로 나오는 위치 찾기
                int idx = lowerBound(arr[i]);

                // 그 위치를 해당 값으로 대체하기
                greedy[idx] = arr[i];
            }
        }

        // maxLength가 이 문제의 답
        System.out.println(maxLength);
    }

    private static int lowerBound(int target) {

        int start = 0;
        int end = maxLength - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (target <= greedy[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}