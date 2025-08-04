import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static class User implements Comparable<User> {
		int level;
		String id;
		
		public User(int level, String id) {
			this.level = level;
			this.id = id;
		}

		@Override
		public int compareTo(User o) {
			return this.id.compareTo(o.id);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<User>> rooms = new ArrayList<>();
		
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
			
			if (rooms.size() == 0) {
				rooms.add(new ArrayList<>());
				rooms.get(0).add(new User(l, n));
			} else {
				// 방에 들어갔는지 여부
				boolean flag = false;
				for (List<User> room : rooms) {
					// 정원이 가득 차면 continue
					if (room.size() == m) continue;
					
					// 그렇지 않으면 리더의 레벨을 확인
					int leaderLevel = room.get(0).level;
					if (l < leaderLevel - 10 || l > leaderLevel + 10) continue;
					room.add(new User(l, n));
					flag = true;
					break;
				}
				
				if (flag == false) {
					rooms.add(new ArrayList<>());
					rooms.get(rooms.size()-1).add(new User(l, n));
				}
			}
			
		}
		
		for (List<User> room : rooms) {
			room.sort((a, b) -> a.compareTo(b));
			if (room.size() == m) {
				System.out.println("Started!");
			} else {
				System.out.println("Waiting!");
			}
			for (User user : room) {
				System.out.println(user.level + " " + user.id);
			}
		}
	}
	
}