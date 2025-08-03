import java.io.*;
import java.util.*;

public class Main {
	static int result = 0;
	
	public static void check(String word, String target) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < target.length(); i++) {
			map.put(target.charAt(i), map.getOrDefault(target.charAt(i), 0)+1);
		}
		boolean flag = false;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!map.containsKey(c)) {
				if (flag) return;
				flag = true;
			} else {
				if (map.get(c)==0) {
					if (flag) return;
					flag = true;
				} else {
					map.put(c, map.get(c)-1);
				}
			}
		}
		
		int remainCount = 0;
		for (Integer value : map.values()) {
			remainCount += value;
		}
		
		if (remainCount <= 1) result += 1;
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String target = br.readLine();
			
        for (int i = 0; i < n - 1; i++) {
        	String word = br.readLine();
        	check(word, target);
        }
			
        System.out.print(result);
    }
}