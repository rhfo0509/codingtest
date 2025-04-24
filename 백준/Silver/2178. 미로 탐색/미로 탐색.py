from collections import deque
N, M = map(int, input().split())

graph = [[0]*(M+1) for _ in range(N+1)]
visited = [[False]*(M+1) for _ in range(N+1)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y):
  q = deque([(x, y)])
  visited[x][y] = True
  
  while q:
    px, py = q.popleft()
    for i in range(4):
      nx = px + dx[i]
      ny = py + dy[i]

      if 0 < nx <= N and 0 < ny <= M and graph[nx][ny] != 0 and not visited[nx][ny]:
        graph[nx][ny] = graph[px][py] + 1
        q.append((nx, ny))
        visited[nx][ny] = True

for i in range(1, N+1):
  graph[i] = [0] + list(map(int, input()))

dfs(1, 1)
print(graph[N][M])