import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	static class Atom implements Comparable<Atom>{
		int x;
		int y;
		int dir;
		int K;
		
		Atom(int x, int y, int dir, int K) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.K = K;
		}
		
		@Override
		public int compareTo(Atom o) {
			// 1. x좌표를 먼저 비교합니다.
            if (this.x != o.x) {
                return Integer.compare(this.x, o.x);
            }
            // 2. x좌표가 같다면, 그 때 y좌표를 비교합니다.
            return Integer.compare(this.y, o.y);
		}
	}
	
	static class Pair implements Comparable<Pair>{
		int i;
		int j;
		int time;
		
		Pair(int i, int j, int time) {
			this.i = i;
			this.j = j;
			this.time = time;
		}
		
		@Override
		public int compareTo(Pair o) {
			return this.time - o.time;
		}
	}
	
    static int N;
    static ArrayList<Atom> list;
    static ArrayList<Pair> boomList;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	list = new ArrayList<>();
        	boomList = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
            	int x = Integer.parseInt(st.nextToken()) * 2;
                int y = Integer.parseInt(st.nextToken()) * 2;
                int d = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());
                
                list.add(new Atom(x, y, d, K));
            }
            
            System.out.println("#" + tc + " " + makeBoomPair());
        }
    }
    
    static int makeBoomPair() {
    	Collections.sort(list);
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = i + 1; j < N; j++) {
    			Atom a = list.get(i);
    			Atom b = list.get(j);
    			
    			// 수직선에서 만날 때
    			if (a.x == b.x && a.dir == 0 && b.dir == 1) {
    				boomList.add(new Pair(i, j, Math.abs(b.y - a.y) / 2));
    			}
    			
    			// 수평선에서 만날 때
    			if (a.y == b.y && a.dir == 3 && b.dir == 2) {
    				boomList.add(new Pair(i, j, Math.abs(b.x - a.x) / 2));
    			}
    			
    			// / 대각선 라인에 있는 대상들이 만날 때
    			if (a.x - a.y == b.x - b.y) {
    				if ((a.dir == 3 && b.dir == 1) || (a.dir == 0 && b.dir == 2)) {
    					boomList.add(new Pair(i, j, Math.abs(a.x - b.x)));
    				}
    			}
    			
    			// \ 대각선 라인에 있는 대상들이 만날 때
    			if (a.x + a.y == b.x + b.y) {
    				if ((a.dir == 1 && b.dir == 2) || (a.dir == 3 && b.dir == 0)) {
    					boomList.add(new Pair(i, j, Math.abs(a.x - b.x)));
    				}
    			}
    		}
    	}
    	
    	return getTotalEnerge(boomList);
    }
    
    static int getTotalEnerge(ArrayList<Pair> boomList) {
    	Collections.sort(boomList);
    	int INF = Integer.MAX_VALUE;
    	int[] boomTimes = new int[N];
    	Arrays.fill(boomTimes, INF);
    	int sum = 0;
    	
    	for (Pair p : boomList) {
			if (boomTimes[p.i] < p.time || boomTimes[p.j] < p.time) continue;
			
			if (boomTimes[p.i] == INF) {
				boomTimes[p.i] = p.time;
				sum += list.get(p.i).K;
			}
			if (boomTimes[p.j] == INF) {
				boomTimes[p.j] = p.time;
				sum += list.get(p.j).K;
			}
		}
    	
    	return sum;
    }
}
