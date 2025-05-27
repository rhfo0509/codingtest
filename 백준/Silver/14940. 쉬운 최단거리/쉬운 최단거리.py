from collections import deque
n,m=map(int,input().split())
data=[list(map(int,input().split())) for _ in range(n)]
visited=[[-1]*m for _ in range(n)]
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def bfs(x,y):
  q=deque([(x,y)])
  visited[x][y]=0
  while q:
    px,py=q.popleft()
    for i in range(4):
      nx,ny=px+dx[i],py+dy[i]
      if 0<=nx<n and 0<=ny<m and data[nx][ny]!=0 and visited[nx][ny]==-1:
        q.append((nx,ny))
        visited[nx][ny]=visited[px][py]+1
for i in range(n):
  for j in range(m):
    if data[i][j]==2:
      bfs(i,j)
for i in range(n):
  for j in range(m):
    if visited[i][j]==-1 and data[i][j]==0:
      visited[i][j]=0
    print(visited[i][j],end=' ')
  print()