from collections import deque
N=int(input())
data=[list(map(int,input())) for _ in range(N)]
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def dfs(x,y):
  q=deque([(x,y)])
  data[x][y]=0
  area=1
  while q:
    px,py=q.popleft()
    for i in range(4):
      nx=px+dx[i]
      ny=py+dy[i]
      if 0<=nx<N and 0<=ny<N and data[nx][ny]!=0:
        area+=1
        data[nx][ny]=0
        q.append((nx,ny))
  return area
cnt=0
area=[]
for i in range(N):
  for j in range(N):
    if data[i][j]!=0:
      area.append(dfs(i,j))
      cnt+=1
print(cnt)
print('\n'.join(map(str,sorted(area))))