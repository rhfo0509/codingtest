import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            List<Integer> arr = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                int e = Integer.parseInt(st.nextToken());
                set.add(e);
                arr.add(e);
            }
            Collections.sort(arr);
            if (set.contains(0)) {
                break;
            }
            if (set.size() == 1) {
                System.out.println("Equilateral");
            } else if (set.size() == 2) {
                if (arr.get(0) + arr.get(1) > arr.get(2)) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Invalid");
                }
            } else {
                if (arr.get(0) + arr.get(1) > arr.get(2)) {
                    System.out.println("Scalene");
                } else {
                    System.out.println("Invalid");
                }
            }
        }
    }
}