T=10
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def dfs(x,y,d,v):
  s=[(x,y)]
  v[x][y]=True
  while s:
    px,py=s.pop()
    if d[px][py]==3:
      return 1
    for i in range(4):
      nx=px+dx[i]
      ny=py+dy[i]
      if d[nx][ny]!=1 and not v[nx][ny]:
        v[nx][ny]=True
        s.append((nx,ny))
  return 0
  
for _ in range(T):
  N=int(input())
  maze=[list(map(int,input())) for _ in range(100)]
  visited=[[False]*100 for _ in range(100)]
  for i in range(100):
    for j in range(100):
      if maze[i][j]==2:
        result=dfs(i,j,maze,visited)
        print(f'#{N} {result}')