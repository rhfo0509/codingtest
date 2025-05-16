from collections import deque
N = int(input())

# U, L, R, D 순서
dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]

def bfs(x, y, time, count, size):

  # 먹은 물고기의 좌표
  fishes = []

  visited = [[0] * N for _ in range(N)]

  cur = visited[x][y] = 1
  data[x][y] = size

  q = deque([(x, y)])

  while q:
    px, py = q.popleft()

    if 0 < data[px][py] < size:

      fishes.append((visited[px][py], px, py))

    for i in range(4):
      nx, ny = px + dx[i], py + dy[i]

      if 0 <= nx < N and 0 <= ny < N and data[nx][ny] <= data[x][y] and not visited[nx][ny]:
        visited[nx][ny] = visited[px][py] + 1
        q.append((nx, ny))

  # 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
  if not fishes:
    return None
  
  fishes.sort(key = lambda x: (x[0], x[1], x[2]))
  _, nx, ny = fishes[0]

  count += 1

  if count == size:

    count = 0
    size += 1

  # 물고기를 먹으면, 그 칸은 빈 칸이 된다.
  data[x][y] = 0
  return (nx, ny, time + visited[nx][ny] - 1, count, size)

data = [list(map(int, input().split())) for _ in range(N)]

sx, sy = 0, 0
time = 0
count = 0
# 가장 처음에 아기 상어의 크기는 2
size = 2
for i in range(N):
  for j in range(N):
    if data[i][j] == 9:
      sx, sy = i, j

while True:
  result = bfs(sx, sy, time, count, size)
  if result is None:
    break
  sx, sy, time, count, size = result

print(time)