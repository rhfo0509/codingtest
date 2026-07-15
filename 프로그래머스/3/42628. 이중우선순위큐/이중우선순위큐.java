import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> dpq = new TreeMap<>();
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String cmd = st.nextToken();
            if (cmd.equals("I")) {
                int n = Integer.parseInt(st.nextToken());
                dpq.put(n, dpq.getOrDefault(n, 0) + 1);
            } else {
                if (dpq.isEmpty()) continue;
                String n = st.nextToken();
                int target = 0;
                if (n.equals("1")) {
                    target = dpq.lastKey();
                } else {
                    target = dpq.firstKey();
                }
                dpq.put(target, dpq.get(target) - 1);
                if (dpq.get(target) == 0) dpq.remove(target);
            }
        }
        int[] answer = new int[2];
        if (!dpq.isEmpty()) {
            answer[0] = dpq.lastKey();
            answer[1] = dpq.firstKey();
        }
        return answer;
    }
}