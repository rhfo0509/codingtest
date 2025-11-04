import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	// 순서 (인덱스: 타순, 값: 선수 번호)
	static int[] arr;
	// dfs 방문 여부
	static boolean[] visited;
	// 이닝 정보
	static int[][] innings;
	// 최대 점수
	static int maxScore;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[10];
        visited = new boolean[10];
        arr[4] = 1;
        visited[1] = true;
        
        innings = new int[N][10];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 1; j < 10; j++) {
        		innings[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        maxScore = 0;
        // 순서 정하기
        dfs(1);
        System.out.print(maxScore);
    }
    
    static void dfs(int depth) {
		// 4번 타자 자리는 이미 선택된 자리
		if (depth == 4) {
			dfs(depth + 1);
			return;
		}
		
    	if (depth == 10) {
    		// 점수 계산하기
    		calculate();
    		return;
    	}
    	
    	for (int i = 1; i < 10; i++) {
    		if (!visited[i]) {
    			arr[depth] = i;
    			visited[i] = true;
    			dfs(depth + 1);
    			visited[i] = false;
    		}
    	}
    }
    
    static void calculate() {
    	
    	int score = 0;
    	// 현재 주자의 번호
    	int cur = 1;
    	
    	for (int i = 0; i < N; i++) {
    		
    		int outCount = 0;
    		// 현재 주자의 위치 (0 : 1루, 1 : 2루, 2 : 3루)
    		boolean[] pos = new boolean[3];
    		
    		while (outCount < 3) {
    			 
    			int res = innings[i][arr[cur++]];
    			if (cur == 10) cur = 1;
    			
    			if (res == 0) {
    				outCount++;
    				if (outCount == 3) break;
    				continue;
    			}
    			
    			else if (res == 1) {
    				if (pos[2]) score++;
    				pos[2] = pos[1];
    				pos[1] = pos[0];
    				pos[0] = true;
    			}
    			
    			else if (res == 2) {
    				if (pos[2]) score++;
    				if (pos[1]) score++;
    				pos[2] = pos[0];
    				pos[1] = true;
    				pos[0] = false;
    			}
    			
    			else if (res == 3) {
    				if (pos[2]) score++;
    				if (pos[1]) score++;
    				if (pos[0]) score++;
    				pos[2] = true;
    				pos[1] = false;
    				pos[0] = false;
    			}
    			
    			else {
    				score++;
    				if (pos[2]) score++;
    				if (pos[1]) score++;
    				if (pos[0]) score++;
    				pos[2] = false;
    				pos[1] = false;
    				pos[0] = false;
    			}
    		}
    	}
    	
    	// 해당 배치로 최고 점수를 달성했다면 갱신
		maxScore = Math.max(maxScore, score);
    }
}