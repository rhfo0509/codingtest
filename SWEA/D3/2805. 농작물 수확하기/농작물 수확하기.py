from collections import deque
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def bfs(x,y):
  q=deque([(x,y)])
  visited[x][y]=1
  while q:
    px,py=q.popleft()
    if visited[px][py]>N//2:
      break
    for i in range(4):
      nx,ny=px+dx[i],py+dy[i]
      if 0<=nx<N and 0<=ny<N and not visited[nx][ny]:
        visited[nx][ny]=visited[px][py]+1
        q.append((nx,ny))

t=int(input())
for tc in range(1,t+1):
  N=int(input())
  data=[list(map(int,input())) for _ in range(N)]
  visited=[[0]*N for _ in range(N)]
  bfs(N//2,N//2)
  result=0
  for i in range(N):
    for j in range(N):
      if visited[i][j]:
        result+=data[i][j]
  print(f'#{tc} {result}')
