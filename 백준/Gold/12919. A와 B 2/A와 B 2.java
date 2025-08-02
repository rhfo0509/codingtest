import java.io.*;
import java.util.*;

public class Main {
	static int result = 0;
	public static void game(String target, StringBuilder cur) {
		if (target.equals(cur.toString())) {
			result = 1;
			return;
			
		}
		if (target.length()>cur.length()) {
			return;
		}
		
		if (cur.charAt(cur.length()-1)=='A') {
			StringBuilder temp=new StringBuilder(cur.toString());
			temp.deleteCharAt(temp.length()-1);

			game(target,temp);
		}
		if (cur.charAt(0)=='B') {
			StringBuilder temp=new StringBuilder(cur.toString());
			temp.deleteCharAt(0);
			temp.reverse();

			game(target,temp);
		}
		
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder(br.readLine());
        game(s,sb);
        System.out.print(result);
        
    }
}