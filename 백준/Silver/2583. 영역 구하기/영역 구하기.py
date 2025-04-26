from collections import deque
M,N,K=map(int,input().split())
data=[[0]*M for _ in range(N)]
for _ in range(K):
  x1,y1,x2,y2=map(int,input().split())
  for x in range(x1,x2):
    for y in range(y1,y2):
      data[x][y]=1
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def dfs(x,y):
  q=deque([(x,y)])
  data[x][y]=1
  area=1
  while q:
    px,py=q.popleft()
    for i in range(4):
      nx=px+dx[i]
      ny=py+dy[i]
      if 0<=nx<N and 0<=ny<M and data[nx][ny]==0:
        area+=1
        data[nx][ny]=1
        q.append((nx,ny))
  return area
cnt=0
area=[]
for i in range(N):
  for j in range(M):
    if data[i][j]==0:
      area.append(dfs(i,j))
      cnt+=1
print(cnt)
print(*sorted(area))