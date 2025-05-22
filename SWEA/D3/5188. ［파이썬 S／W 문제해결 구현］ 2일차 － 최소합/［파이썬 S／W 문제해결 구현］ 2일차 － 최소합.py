INF=int(1e9)

dx=[1,0]
dy=[0,1]
def dfs(x,y):
  for i in range(2):
    nx,ny=x+dx[i],y+dy[i]
    if 0<=nx<N and 0<=ny<N and dp[x][y]+data[nx][ny]<dp[nx][ny]:
      dp[nx][ny]=dp[x][y]+data[nx][ny]
      dfs(nx,ny)

T=int(input())
for tc in range(1,T+1):
  N=int(input())
  data=[list(map(int,input().split())) for _ in range(N)]
  # (x,y) 위치에서의 최소합
  dp=[[INF]*N for _ in range(N)]
  dp[0][0]=data[0][0]
  dfs(0,0)
  print(f'#{tc} {dp[N-1][N-1]}')