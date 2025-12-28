import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] a={3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
        String word=br.readLine();
        int time=0;
        for (int i=0; i<word.length(); i++) {
            time+=a[word.charAt(i)-'A'];
        }
        System.out.print(time);
    }
}
