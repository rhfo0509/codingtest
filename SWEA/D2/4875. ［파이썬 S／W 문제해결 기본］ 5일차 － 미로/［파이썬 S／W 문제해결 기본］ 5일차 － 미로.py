T=int(input())
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def dfs(x,y):
  global result
  if maze[x][y]==3:
    result=1
    return
  visited[x][y]=True
  for i in range(4):
    nx,ny=x+dx[i],y+dy[i]
    if 0<=nx<N and 0<=ny<N and maze[nx][ny]!=1 and not visited[nx][ny]:
      dfs(nx,ny)
  
for tc in range(1,T+1):
  result=0
  N=int(input())
  maze=[list(map(int,input())) for _ in range(N)]
  visited=[[False]*N for _ in range(N)]
  for i in range(N):
    for j in range(N):
      if maze[i][j]==2:
        dfs(i,j)
  print(f'#{tc} {result}')
