from collections import deque
N=int(input())
d1=[]
d2=[]
for i in range(N):
  s=input()
  d1.append(list(s))
  d2.append(list(s.replace('R','G')))
v1=[[False]*N for _ in range(N)]
v2=[[False]*N for _ in range(N)]
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def bfs(d,v,c,x,y):
  q=deque([(x,y)])
  while q:
    px,py=q.popleft()
    for i in range(4):
      nx=px+dx[i]
      ny=py+dy[i]
      if 0<=nx<N and 0<=ny<N and d[nx][ny]==c and not v[nx][ny]:
        q.append((nx,ny))
        v[nx][ny]=True

c1=0
c2=0
for i in range(N):
  for j in range(N):
    if not v1[i][j]:
      bfs(d1,v1,d1[i][j],i,j)
      c1+=1
    if not v2[i][j]:
      bfs(d2,v2,d2[i][j],i,j)
      c2+=1
print(c1,c2)