import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] p0 = {1, 2, 3, 4, 5};
        int[] p1 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p2 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] c = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p0[i % 5]) c[0]++;
            if (answers[i] == p1[i % 8]) c[1]++;
            if (answers[i] == p2[i % 10]) c[2]++;
        }
        int mx = 0;
        for (int i = 0; i < 3; i++) {
            if (c[i] > mx) {
                mx = c[i];
            }
        }
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (c[i] == mx) {
                li.add(i + 1);
            }
        }
        int[] answer = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            answer[i] = li.get(i);
        }
        return answer;
    }
}