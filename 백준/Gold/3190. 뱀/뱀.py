from collections import deque
N = int(input())
# 0 : 빈 칸
# 1 : 사과
# 2 : 뱀
board = [[0]*N for _ in range(N)]

K = int(input())
for _ in range(K):
  r, c = map(int, input().split())
  board[r - 1][c - 1] = 1

L = int(input())
data = []

for _ in range(L):
  time, direction = input().split()
  data.append((int(time), direction))

# 반복문이 이어지기 위해서 도달할 수 없는 시간을 data에 추가
data.append((10_001, 'D'))

# 현재 시간
cur_time = 0
# 뱀 머리의 위치
cur_x, cur_y = 0, 0
# 뱀 머리의 방향 (처음: 오른쪽)
cur_direction = 0

board[cur_x][cur_y] = 2

# R, D, L, U 순서
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

q = deque([(cur_x, cur_y)])

for time, direction in data:

    while True:

      cur_time += 1
      
      # 1. 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
      cur_x += dx[cur_direction]
      cur_y += dy[cur_direction]

      # 2. 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
      if cur_x < 0 or cur_x >= N or cur_y < 0 or cur_y >= N:
        print(cur_time)
        exit()

      elif board[cur_x][cur_y] == 2:
        print(cur_time)
        exit()
      
      # 3. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
      elif board[cur_x][cur_y] == 1:
        board[cur_x][cur_y] = 2
        q.append((cur_x, cur_y))

      # 4. 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
      else:
        px, py = q.popleft()
        board[px][py] = 0
        board[cur_x][cur_y] = 2
        q.append((cur_x, cur_y))

      if cur_time == time:
        # 시계 반대방향
        if direction == 'L':
          cur_direction = (cur_direction - 1) % 4
        # 시계 방향
        else:
          cur_direction = (cur_direction + 1) % 4
        break