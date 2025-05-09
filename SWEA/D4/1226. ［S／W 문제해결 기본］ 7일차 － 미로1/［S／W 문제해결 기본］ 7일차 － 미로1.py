from collections import deque
T=10
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def bfs(x,y,d,v):
  q=deque([(x,y)])
  v[x][y]=True
  while q:
    px,py=q.popleft()
    if d[px][py]==3:
      return 1
    for i in range(4):
      nx=px+dx[i]
      ny=py+dy[i]
      if 0<=nx<16 and 0<=ny<16 and d[nx][ny]!=1 and not v[nx][ny]:
        v[nx][ny]=True
        q.append((nx,ny))
  return 0
for _ in range(T):
  N=int(input())
  maze=[list(map(int,input())) for _ in range(16)]
  visited=[[False]*16 for _ in range(16)]
  for i in range(16):
    for j in range(16):
      if maze[i][j]==2:
        result=bfs(i,j,maze,visited)
        print(f'#{N} {result}')