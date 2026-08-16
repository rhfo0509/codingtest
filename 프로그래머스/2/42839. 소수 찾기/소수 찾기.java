// 소수 판별법
// 1. 에라토스테네스의 체 : 미리 소수를 선별해놓은 배열 이용
// 2. 2, 3, 4, ... n의 제곱근으로 나누어서 검증하는 함수 만들기
import java.util.*;
class Solution {
    static int count, n;
    static int[] numArr;
    static boolean[] visited;
    static HashSet<Integer> set;
    public int solution(String numbers) {
        n = numbers.length();
        numArr = new int[n];
        visited = new boolean[n];
        set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            numArr[i] = numbers.charAt(i) - '0';
        }
        Arrays.sort(numArr);
        for (int i = 0; i < n; i++) {
            if (numArr[i] != 0) {
                visited[i] = true;
                dfs(numArr[i]);
                visited[i] = false;
            }
        }
        return count;
    }
    public void dfs(int cur) {
        if (set.contains(cur)) return;
        if (isPrime(cur)) count++;
        set.add(cur);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cur * 10 + numArr[i]);
                visited[i] = false;
            }
        }
    }
    public boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}