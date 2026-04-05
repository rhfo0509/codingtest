import java.io.*;
import java.util.*;
public class Main {
  static int T, n, m, dn, dm;
  static long res;
  static long[] A, B, sumA, sumB;
  static List<Long> allA, allB;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    T = Integer.parseInt(br.readLine());
    n = Integer.parseInt(br.readLine());
    A = new long[n];
    sumA = new long[n + 1];
    allA = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      sumA[i + 1] = sumA[i] + A[i];
      allA.add(sumA[i + 1]);
    }
    dn = 1;
    while (dn < n) {
      for (int i = 1; i <= n - dn; i++) {
        allA.add(sumA[i + dn] - sumA[i]);
      }
      dn++;
    }
    m = Integer.parseInt(br.readLine());
    B = new long[m];
    sumB = new long[m + 1];
    allB = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      B[i] = Integer.parseInt(st.nextToken());
      sumB[i + 1] = sumB[i] + B[i];
      allB.add(sumB[i + 1]);
    }
    dm = 1;
    while (dm < m) {
      for (int i = 1; i <= m - dm; i++) {
        allB.add(sumB[i + dm] - sumB[i]);
      }
      dm++;
    }

    Collections.sort(allA);
    Collections.sort(allB);

    for (int i = 0; i < allA.size(); i++) {
      res += upperBound(T - allA.get(i), allB) - lowerBound(T - allA.get(i), allB);
    }
    System.out.print(res);
  }
  static int upperBound(long target, List<Long> all) {
    int start = 0;
    int end = all.size() - 1;
    int ans = all.size();
    while (start <= end) {
      int mid = (start + end) / 2;
      if (all.get(mid) > target) {
        ans = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return ans;
  }
  static int lowerBound(long target, List<Long> all) {
    int start = 0;
    int end = all.size() - 1;
    int ans = all.size();
    while (start <= end) {
      int mid = (start + end) / 2;
      if (all.get(mid) >= target) {
        ans = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return ans;
  }
}