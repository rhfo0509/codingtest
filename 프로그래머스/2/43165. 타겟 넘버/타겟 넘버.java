import java.util.*;
class Solution {
    static int answer, t;
    public int solution(int[] numbers, int target) {
        t = target;
        dfs(numbers, 0, 0);
        return answer;
    }
    static void dfs(int[] numbers, int sum, int depth) {
        if (depth == numbers.length) {
            if (sum == t) {
                answer++;
            }
            return;
        }
        dfs(numbers, sum - numbers[depth], depth + 1);
        dfs(numbers, sum + numbers[depth], depth + 1);
    }
}