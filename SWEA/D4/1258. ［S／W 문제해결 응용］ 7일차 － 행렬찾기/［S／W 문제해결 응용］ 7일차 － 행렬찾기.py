from collections import deque
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def bfs(x,y):
  q=deque([(x,y)])
  visited[x][y]=True
  lx,ly=x,y
  while q:
    px,py=q.popleft()
    lx,ly=px,py
    count=0
    for i in range(4):
      nx,ny=px+dx[i],py+dy[i]
      if 0<=nx<n and 0<=ny<n and data[nx][ny]>0 and not visited[nx][ny]:
        q.append((nx,ny))
        visited[nx][ny]=True
  return lx,ly

T=int(input())
for tc in range(1,T+1):
  n=int(input())
  data=[list(map(int,input().split())) for _ in range(n)]
  visited=[[False]*n for _ in range(n)]
  result=[]

  for i in range(n):
    for j in range(n):
      if data[i][j]>0 and not visited[i][j]:
        x1,y1=i,j
        x2,y2=bfs(i,j)
        r,c=x2-x1+1,y2-y1+1
        area=r*c
        result.append((area,r,c))
  
  result.sort(key=lambda x:(x[0], x[1]))

  print(f'#{tc} {len(result)}',end=' ')
  for i in range(len(result)):
    _,r,c=result[i]
    print(f'{r} {c}',end=' ')
