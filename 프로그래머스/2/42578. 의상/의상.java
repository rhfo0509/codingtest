import java.util.*;
class Solution {
    static List<Integer> counts;
    static int answer = 0;
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] arr : clothes) {
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }
        counts = new ArrayList<>(map.values());
        for (int i = 0; i < counts.size(); i++) {
            answer += counts.get(i);
            comb(i, counts.get(i));
        }
        
        return answer;
    }
    static void comb(int cur, int val) {
        for (int i = cur + 1; i < counts.size(); i++) {
            answer += val * counts.get(i);
            comb(i, val * counts.get(i));
        }
    }
}