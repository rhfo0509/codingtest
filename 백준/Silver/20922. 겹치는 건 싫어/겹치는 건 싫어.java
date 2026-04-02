import java.io.*;
import java.util.*;
public class Main {
  static int N, K, s, e, res;
  static int[] arr;
  static HashMap<Integer, Integer> map;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new int[N];
    map = new HashMap<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    map.put(arr[e], 1);
    while (s <= e) {
      if (map.get(arr[e]) <= K) {
        res = Math.max(res, e - s + 1);
        e++;
        if (e == N) break;
        map.put(arr[e], map.getOrDefault(arr[e], 0) + 1);
      } else {
        map.put(arr[s], map.get(arr[s]) - 1);
        s++;
      }
    }
    System.out.print(res);
  }
}