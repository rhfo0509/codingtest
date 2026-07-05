import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = speeds.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            if (remain % speeds[i] == 0) {
                arr[i] = remain / speeds[i];
            } else {
                arr[i] = (remain / speeds[i]) + 1;
            }
        }
        List<Integer> li = new ArrayList<>();
        int cur = arr[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (cur < arr[i]) {
                li.add(cnt);
                cur = arr[i];
                cnt = 1;
            } else {
                cnt++;
            }
        }
        li.add(cnt);
        int[] res = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            res[i] = li.get(i);
        }
        return res;
    }
}