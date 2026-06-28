import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> q = new ArrayDeque();
        char[] arr = s.toCharArray();
        q.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (q.isEmpty()) {
                q.push(arr[i]);
            } else if (q.peek() == '(' && arr[i] == ')') {
                q.pop();
            } else {
                q.push(arr[i]);
            }
        }
        if (q.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}