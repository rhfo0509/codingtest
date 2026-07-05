import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int idx = commands[i][2] - 1;
            List<Integer> tmp = new ArrayList<>();
            for (int j = start; j <= end; j++) {
                tmp.add(array[j]);
            }
            Collections.sort(tmp);
            answer[i] = tmp.get(idx);
        }
        return answer;
    }
}