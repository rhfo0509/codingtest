from collections import deque
N = int(input())
data = [list(map(int, input().split())) for _ in range(N)]

dx=[-1,1,0,0]
dy=[0,0,-1,1]
def bfs(x, y, data, visited):
  q = deque([(x, y)])
  while q:
    px, py = q.popleft()
    for i in range(4):
      nx = px + dx[i]
      ny = py + dy[i]

      if 0<=nx<N and 0<=ny<N and data[nx][ny]==1 and not visited[nx][ny]:
        visited[nx][ny]=True
        q.append((nx, ny))

res=0
for h in range(101):
  tmp = [[0]*N for _ in range(N)]
  visited = [[False]*N for _ in range(N)]
  cnt=0
  for i in range(N):
    for j in range(N):
      if data[i][j]>h:
        tmp[i][j]=1

  for i in range(N):
    for j in range(N):
      if tmp[i][j]==1 and not visited[i][j]:
        bfs(i, j, tmp, visited)
        cnt+=1

  res=max(res, cnt)
print(res)