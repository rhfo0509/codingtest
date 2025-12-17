import java.io.*;
import java.util.*;
public class Main {
    static int N, M, count, time;
    static Integer[] cranes, boxes;
    static boolean[] visited;
    static int[] idxArr;
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
         cranes = new Integer[N];
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 0; i < N; i++) {
             cranes[i] = Integer.parseInt(st.nextToken());
         }
         M = Integer.parseInt(br.readLine());
         boxes = new Integer[M];
         st = new StringTokenizer(br.readLine());
         for (int i = 0; i < M; i++) {
             boxes[i] = Integer.parseInt(st.nextToken());
         }
         Arrays.sort(cranes, Collections.reverseOrder());
         Arrays.sort(boxes, Collections.reverseOrder());
         if (boxes[0] > cranes[0]) {
             System.out.print(-1);
             System.exit(0);
         }
         count = 0;
         time = 0;
         visited = new boolean[M];
         idxArr = new int[N];
         while (count < M) {
             time++;
             for (int i = 0; i < N; i++) {
                 while (idxArr[i] < M && (cranes[i] < boxes[idxArr[i]] || visited[idxArr[i]])) {
                     idxArr[i]++;
                 }
                 if (idxArr[i] == M) continue;
                 count++;
                 visited[idxArr[i]] = true;
                 idxArr[i]++;
             }
         }
        System.out.print(time);
    }
}