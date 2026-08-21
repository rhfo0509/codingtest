import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 체육복이 있는 학생
        boolean[] person = new boolean[n + 1];
        Arrays.fill(person, true);
        for (int l : lost) {
            person[l] = false;
        }
        // 여벌 체육복이 있는 학생
        boolean[] reservePerson = new boolean[n + 1];
        for (int r : reserve) {
            if (!person[r]) {
                person[r] = true;
            } else {
                reservePerson[r] = true;
            }
        }
        for (int l : lost) {
            if (l - 1 > 0 && reservePerson[l - 1]) {
                if (person[l - 1]) {
                    person[l] = true;
                    reservePerson[l - 1] = false;
                }
            } else if (l + 1 <= n && reservePerson[l + 1]) {
                if (person[l + 1]) {
                    person[l] = true;
                    reservePerson[l + 1] = false;
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (person[i]) {
                answer++;
            }
        }
        return answer;
    }
}