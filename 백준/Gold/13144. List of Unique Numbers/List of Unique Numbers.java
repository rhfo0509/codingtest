import java.io.*;
import java.util.*;

public class Main {
  static int N, start, end;
  static long cnt;
  static int[] arr;
  static HashSet<Integer> set;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    set = new HashSet<>();
    while (start <= end && end < N) {
      set.add(arr[end]);

      if (end - start + 1 == set.size()) {
        cnt += (end - start + 1);
        end++;
      } else {
        set.remove(arr[start]);
        start++;
      }
    }
    System.out.print(cnt);
  }
}