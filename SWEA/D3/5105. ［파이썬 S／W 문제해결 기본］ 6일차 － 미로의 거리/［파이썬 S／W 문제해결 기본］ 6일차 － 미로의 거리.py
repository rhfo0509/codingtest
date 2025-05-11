from collections import deque
T=int(input())
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def bfs(x,y):
  q=deque([(x,y)])
  visited[x][y]=1
  while q:
    px,py=q.popleft()
    if maze[px][py]==3:
      return visited[px][py]-2
    for i in range(4):
      nx=px+dx[i]
      ny=py+dy[i]
      if 0<=nx<N and 0<=ny<N and maze[nx][ny]!=1 and not visited[nx][ny]:
        visited[nx][ny]=visited[px][py]+1
        q.append((nx,ny))
  return 0    

for tc in range(1,T+1):
  N=int(input())
  maze=[list(map(int,input())) for _ in range(N)]
  visited=[[False]*N for _ in range(N)]
  for i in range(N):
    for j in range(N):
      if maze[i][j]==2:
          print(f'#{tc} {bfs(i,j)}')
