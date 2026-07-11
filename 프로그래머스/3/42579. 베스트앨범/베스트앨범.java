import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, List<int[]>> map2 = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map1.put(genres[i], map1.getOrDefault(genres[i], 0) + plays[i]);
            if (map2.get(genres[i]) == null) {
                map2.put(genres[i], new ArrayList<>());
            }
            map2.get(genres[i]).add(new int[]{i, plays[i]});
        }
        List<String> titles = new ArrayList<>(map1.keySet());
        titles.sort((a, b) -> Integer.compare(map1.get(b), map1.get(a)));
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            List<int[]> list = map2.get(titles.get(i));
            list.sort((a, b) -> Integer.compare(b[1], a[1]));
            int cnt = 0;
            for (int j = 0; j < list.size(); j++) {
                answer.add(list.get(j)[0]);
                cnt++;
                if (cnt == 2) break;
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}