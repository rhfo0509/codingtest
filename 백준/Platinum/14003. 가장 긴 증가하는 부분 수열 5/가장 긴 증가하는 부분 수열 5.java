import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr, greedy, pos;
    static boolean[] visited;
    static int maxLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        // LIS의 최대 길이
        maxLen = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // greedy[len]: LIS의 길이가 len+1 일때 마지막 원소로 올 수 있는 값의 최소값
        greedy = new int[N];

        // LIS 경로 출력을 위한 배열
        // pos[i]: arr[i]은 LIS에서 몇 번째 자리 후보였는지?
        pos = new int[N];

        greedy[maxLen++] = arr[0];
        pos[0] = 1;

        for (int i = 1; i < N; i++) {
            int lastIdx = maxLen - 1;
            if (greedy[lastIdx] < arr[i]) {
                greedy[maxLen++] = arr[i];
                pos[i] = maxLen;
            } else {
                // arr[i]보다 크거나 같은 최소 인덱스 찾기
                int idx = lowerBound(arr[i]);
                greedy[idx] = arr[i];
                pos[i] = idx + 1;
            }
        }

        System.out.println(maxLen);

        // 해당 인덱스가 LIS에 포함되는지 여부 확인 배열
        visited = new boolean[N];
        int curPos = maxLen;
        for (int i = N - 1; i >= 0; i--) {
            if (pos[i] == curPos) {
                visited[i] = true;
                curPos--;
            }
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) System.out.print(arr[i] + " ");
        }
    }

    private static int lowerBound(int target) {
        int start = 0;
        int end = maxLen - 1;

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
