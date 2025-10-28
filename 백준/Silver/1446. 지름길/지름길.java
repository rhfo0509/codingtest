import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	// N: 지름길의 개수, D: 고속도로의 길이, minDist: 거리의 최솟값
	static int N, D, minDist;
	// 지름길 클래스
	static class Shortcut implements Comparable<Shortcut> {
		int start;
		int end;
		int cost;
		
		Shortcut(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Shortcut o) {
			if (start == o.start) {
				return end - o.end;
			}
			return start - o.start;
		}
	}
	// 지름길들을 담고 있는 배열
	static List<Shortcut> shortcuts;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		shortcuts = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			shortcuts.add(new Shortcut(start, end, cost));
		}
		
		// 시작 위치 -> 도착 위치 순으로 정렬
		Collections.sort(shortcuts);
		
		minDist = D;
		dfs(0, 0, D);
		System.out.println(minDist);
	}

	static void dfs(int start, int curPos, int curDist) {
		
		minDist = Math.min(minDist, curDist);
		for (int i = start; i < N; i++) {
			
			Shortcut s = shortcuts.get(i);
			
			if (s.end - s.start <= s.cost) continue;
			if (s.end > D) continue;
			if (curPos > s.start) continue;
			
			dfs(i + 1, s.end, curDist - (s.end - s.start) + s.cost);
		}
	}
}