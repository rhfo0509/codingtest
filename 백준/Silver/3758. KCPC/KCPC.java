import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	// 팀의 개수
        	int n = Integer.parseInt(st.nextToken());
        	// 문제의 개수
        	int k = Integer.parseInt(st.nextToken());
        	// 당신 팀의 ID
        	int t = Integer.parseInt(st.nextToken());
        	// 로그 엔트리의 개수
        	int m = Integer.parseInt(st.nextToken());
        	
        	// 획득한 총 점수를 기억하는 배열
        	int[][] total = new int[n + 1][k + 1]; 
        	
        	// 제출 횟수를 기억하는 배열
        	int[] count = new int[n + 1];
        	
        	// 마지막 제출 시점을 기억하는 배열
        	int[] lastTime = new int[n + 1];
        	
        	for (int i = 1; i <= m; i++) {
        		st = new StringTokenizer(br.readLine());
        		
        		int id = Integer.parseInt(st.nextToken());
        		int num = Integer.parseInt(st.nextToken());
        		int score = Integer.parseInt(st.nextToken());
        		
        		total[id][num] = Math.max(total[id][num], score);
        		count[id] += 1;
        		lastTime[id] = i;
        	}
        	
        	// 순위 계산
        	int rank = 1;
        	for (int i = 1; i <= n; i++) {
        		// 자기 자신이면 continue
        		if (i == t) continue;
        		
        		int iSum = Arrays.stream(total[i]).sum();
        		int tSum = Arrays.stream(total[t]).sum();
        		
        		// 내가 점수가 더 낮으면 순위 증가
        		if (iSum > tSum) rank++;
        		
        		// 점수가 같다면
        		if (iSum == tSum) {
        			
        			// 1. 최종 점수가 같은 경우, 풀이를 제출한 횟수가 적은 팀의 순위가 높다. 
        			if (count[i] != count[t]) {
        				if (count[i] < count[t]) rank++;
        				continue;
        			} else {
        				// 2. 최종 점수도 같고 제출 횟수도 같은 경우, 마지막 제출 시간이 더 빠른 팀의 순위가 높다.
        				if (lastTime[i] < lastTime[t]) {
            				rank++;
            			}
        			}
        		}
        	}
        	System.out.println(rank);
        }
    }
}