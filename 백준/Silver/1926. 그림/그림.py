from collections import deque
n, m = map(int, input().split())

cnt = 0
max_area = 0
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

# 상, 하, 좌, 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y):
  area = 0
  # 1. 시작 값은 큐에 넣고 방문 처리
  q = deque([(x, y)])
  visited[x][y] = True
  area += 1

  while q:
    px, py = q.popleft()
    for k in range(4):
      nx = px + dx[k]
      ny = py + dy[k]
      if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1 and not visited[nx][ny]:
        # 2. 큐에 넣기
        q.append((nx, ny))
        # 3. 방문 처리하기
        visited[nx][ny] = True
        area += 1

  # 넓이를 반환
  return area


for i in range(n):
  for j in range(m):
    if not visited[i][j] and graph[i][j] == 1:
      cnt += 1
      max_area = max(max_area, dfs(i, j))

print(cnt)
print(max_area)