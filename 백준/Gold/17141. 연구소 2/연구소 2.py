from collections import deque
import copy

N, M = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]

area = []
for i in range(N):
  for j in range(N):
    if data[i][j] == 1:
      # 벽: -1
      data[i][j] = -1
    elif data[i][j] == 2:
      area.append((i, j))
      data[i][j] = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 바이러스 전파
def bfs(selected):
  q = deque([])
  c_data = copy.deepcopy(data)
  c_visited = copy.deepcopy(visited)
  for x, y in selected:
    # 최초 바이러스가 있는 곳의 시간을 1로 설정 (나중에 -1)
    c_data[x][y] = 1
    c_visited[x][y] = True
    q.append((x, y))

  while q:
    px, py = q.popleft()
    for i in range(4):
      nx = px + dx[i]
      ny = py + dy[i]

      if 0 <= nx < N and 0 <= ny < N and c_data[nx][ny] != -1 and not c_visited[nx][ny]:
        c_data[nx][ny] = c_data[px][py] + 1
        c_visited[nx][ny] = True
        q.append((nx, ny))

  mx = 0
  for i in range(N):
    for j in range(N):
      if c_data[i][j] == -1:
        continue
      elif c_data[i][j] == 0:
        return -1
      else:
        mx = max(mx, c_data[i][j])
  return mx - 1

# 바이러스 구역 선택
def dfs(start, selected):
  global result

  if len(selected) == M:
    tmp = bfs(selected)
    if tmp != -1:
      result = min(result, bfs(selected))
    return

  for i in range(start, len(area)):
    dfs(i + 1, selected + [area[i]])

result = int(1e9)
dfs(0, [])
print(-1) if result == int(1e9) else print(result)