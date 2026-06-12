import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        Arrays.sort(phone_book, (a, b) -> a.length() - b.length());
        for (String s : phone_book) {
            StringBuilder sb = new StringBuilder();
            char[] arr = s.toCharArray();
            for (char c : arr) {
                sb.append(c);
                if (set.contains(sb.toString())) {
                    return false;
                }
            }
            set.add(sb.toString());
        }
        return true;
    }
}