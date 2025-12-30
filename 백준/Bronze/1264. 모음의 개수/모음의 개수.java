import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int count = 0;
            String sentence = br.readLine();
            if (sentence.equals("#")) break;
            for (int i = 0; i < sentence.length(); i++) {
                if (Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(sentence.charAt(i))) count++;
            }
            System.out.println(count);
        }
    }
}