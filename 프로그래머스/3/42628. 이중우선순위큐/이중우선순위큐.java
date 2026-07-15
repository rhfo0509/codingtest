import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> dpq = new TreeSet<>();
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String cmd = st.nextToken();
            if (cmd.equals("I")) {
                String n = st.nextToken();
                dpq.add(Integer.parseInt(n));
            } else {
                if (dpq.isEmpty()) continue;
                String n = st.nextToken();
                if (n.equals("1")) {
                    dpq.pollLast();
                } else {
                    dpq.pollFirst();
                }
            }
        }
        int[] answer = new int[2];
        if (!dpq.isEmpty()) {
            answer[0] = dpq.last();
            answer[1] = dpq.first();
        }
        return answer;
    }
}