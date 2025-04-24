import sys
from collections import deque

input = sys.stdin.readline
R, C = map(int, input().split())

# 불이 퍼지는 경로
maze = [list(input().rstrip()) for _ in range(R)]
# 지훈이의 경로
path = [['.'] * C for _ in range(R)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# q1: FIRE
q1 = deque([])
# q2: JIHUN
q2 = deque([])
for x in range(R):
  for y in range(C):
    if maze[x][y] == 'F':
      q1.append((x, y))
      maze[x][y] = 0
    elif maze[x][y] == 'J':
      q2.append((x, y))
      path[x][y] = 0

# 1. 불을 먼저 이동시킨다.
while q1:
  x1, y1 = q1.popleft()

  for i in range(4):
    fx = x1 + dx[i]
    fy = y1 + dy[i]

    if 0 <= fx < R and 0 <= fy < C and maze[fx][fy] != '#' and not str(maze[fx][fy]).isnumeric():
      maze[fx][fy] = maze[x1][y1] + 1
      q1.append((fx, fy))

# 2. 지훈이를 이동시킨다.
while q2:
  x2, y2 = q2.popleft()

  # 탈출 조건
  if x2 == 0 or x2 == R - 1 or y2 == 0 or y2 == C - 1:
    print(path[x2][y2] + 1)
    exit()

  for i in range(4):
    jx = x2 + dx[i]
    jy = y2 + dy[i]

    if jx < 0 or jx >= R or jy < 0 or jy >= C:
      continue

    if maze[jx][jy] == '#':
      continue

    if path[jx][jy] != '.':
      continue

    # 숫자가 아닌 경우
    if maze[jx][jy] == '.' or maze[jx][jy] == 'J':
      path[jx][jy] = path[x2][y2] + 1
      q2.append((jx, jy))
      continue

    # 숫자인 경우
    if path[x2][y2] + 1 >= maze[jx][jy]:
      continue

    path[jx][jy] = path[x2][y2] + 1
    q2.append((jx, jy))

# 탈출 못하는 경우: 더 이상 이동할 곳이 없을 때
print('IMPOSSIBLE')