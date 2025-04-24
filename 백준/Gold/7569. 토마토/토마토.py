from collections import deque
M, N, H = map(int, input().split())

graph = []
for _ in range(H):
  graph.append([list(map(int, input().split())) for _ in range(N)])

# 앞, 뒤, 왼쪽, 오른쪽, 위, 아래
dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

q = deque([])
for i in range(H):
  for j in range(N):
    for k in range(M):
      if graph[i][j][k] == 1:
        q.append((i, j, k))

while q:
  pz, px, py = q.popleft()
  for i in range(6):
    nz = pz + dz[i]
    nx = px + dx[i]
    ny = py + dy[i]

    if 0 <= nz < H and 0 <= nx < N and 0 <= ny < M and graph[nz][nx][ny] == 0:
      graph[nz][nx][ny] = graph[pz][px][py] + 1
      q.append((nz, nx, ny))

result = 0
for i in range(H):
  for j in range(N):
    for k in range(M):
      if graph[i][j][k] == 0:
        print(-1)
        exit()
      result = max(result, graph[i][j][k])

print(result - 1)