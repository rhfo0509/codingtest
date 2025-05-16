# 보급로
# BFS+DP
from collections import deque
T=int(input())
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def bfs(x,y,t):
  q=deque([(x,y)])
  dp[x][y]=t
  while q:
    px,py=q.popleft()
    for i in range(4):
      nx,ny=px+dx[i],py+dy[i]
      if 0<=nx<N and 0<=ny<N and dp[px][py]+data[nx][ny]<dp[nx][ny]:
        dp[nx][ny]=dp[px][py]+data[nx][ny]
        q.append((nx,ny))

for tc in range(1,T+1):
  N=int(input())
  data=[list(map(int,input())) for _ in range(N)]
  visited=[[False]*N for _ in range(N)]
  dp=[[N*N*9]*N for _ in range(N)]
  bfs(0,0,0)
  print(f'#{tc} {min(dp[N-2][N-1], dp[N-1][N-2])}')