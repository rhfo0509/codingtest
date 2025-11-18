import java.io.*;
import java.util.*;

public class Main {

    static int n, count, maxLen;
    static int[] arr, lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lis = new int[n];
        // lis[i] : 길이가 i+1인 부분 수열의 마지막 원소 중 가장 큰 값
        lis[0] = arr[0];
        // maxLen : lis가 가리키는 현재 포인터 위치
        maxLen = 1;
        for (int i = 1; i < n; i++) {
            if (lis[maxLen - 1] < arr[i]) {
                lis[maxLen++] = arr[i];
            } else {
                // 이분 탐색 ㅡ lower-bound
                int idx = lowerBound(arr[i]);
                lis[idx] = arr[i];
            }
        }

        // 0 이 되기 전까지의 수열의 길이가 곧 LIS의 답
        for (int i = 0; i < n; i++) {
            if (lis[i] == 0) break;
            count++;
        }
        System.out.print(count);
    }
    static int lowerBound(int target) {
        int start = 0;
        int end = maxLen - 1;
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