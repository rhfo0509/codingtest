import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int L, C;
    static String[] arr;
    static boolean[] visited;
    static String[] result;
    static final Set<String> vowels = Set.of("a", "e", "i", "o", "u");

    static void dfs(int start, int depth, String[] result, int vowelCount, int consonantCount) {
        if (depth == L) {
            if (vowelCount >= 1 && consonantCount >= 2) {
                for (int i = 0; i < L; i++) {
                    System.out.print(result[i]);
                }
                System.out.println();
            }
            return;
        }
        for (int i = start; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                if (vowels.contains(result[depth])) {
                    dfs(i + 1, depth + 1, result, vowelCount + 1, consonantCount);
                } else {
                    dfs(i + 1, depth + 1, result, vowelCount, consonantCount + 1);
                }

                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);

        result = new String[L];
        visited = new boolean[C];
        dfs(0, 0, result, 0, 0);
    }
}
