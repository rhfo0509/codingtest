import java.io.*;
import java.util.*;
public class Main {
  static int N, res;
  static int[] time, dp, indegree;
  static List<List<Integer>> graph;
  static Deque<Integer> q;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }
    time = new int[N + 1];
    dp = new int[N + 1];
    indegree = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      time[i] = a;
      dp[i] = a;
      int b = Integer.parseInt(st.nextToken());
      for (int j = 0; j < b; j++) {
        int c = Integer.parseInt(st.nextToken());
        graph.get(c).add(i);
        indegree[i]++;
      }
    }
    q = new ArrayDeque<>();
    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
      }
    }
    while (!q.isEmpty()) {
      int cur = q.poll();
      for (int next : graph.get(cur)) {
        dp[next] = Math.max(dp[next], dp[cur] + time[next]);
        if (--indegree[next] == 0) {
          q.offer(next);
        }
      }
    }
    for (int i = 1; i <= N; i++) {
     res = Math.max(res, dp[i]);
    }
    System.out.print(res);
  }
}