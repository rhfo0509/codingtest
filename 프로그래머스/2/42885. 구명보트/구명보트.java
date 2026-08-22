import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        
        int start = n - 1;
        int end = 0;
        while (start > end) {
            if (people[start] + people[end] <= limit) {
                count++;
                start--;
                end++;
            } else {
                start--;
            }
        }

        count += n - (count * 2);
        return count;
    }
}