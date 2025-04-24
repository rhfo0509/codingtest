from collections import deque
M, N = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

q = deque([])
for i in range(N):
  for j in range(M):
    if graph[i][j] == 1:
      q.append((i, j))


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

while q:
  px, py = q.popleft()
  for i in range(4):
    nx = px + dx[i]
    ny = py + dy[i]

    if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 0:
      graph[nx][ny] = graph[px][py] + 1
      q.append((nx, ny))

result = 0
for i in range(N):
  for j in range(M):
    if graph[i][j] == 0:
      print(-1)
      exit()
    
    result = max(result, graph[i][j])

print(result - 1)