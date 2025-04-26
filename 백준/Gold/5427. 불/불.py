import sys
from collections import deque
input=sys.stdin.readline
T=int(input())
dx=[-1,1,0,0]
dy=[0,0,-1,1]
for _ in range(T):
  w,h=map(int,input().split())
  maze=[list(input().rstrip()) for _ in range(h)]
  path=[['.']*w for _ in range(h)]
  q1=deque([])
  q2=deque([])
  for x in range(h):
    for y in range(w):
      if maze[x][y]=='*':
        q1.append((x,y))
        maze[x][y]=0
      elif maze[x][y]=='@':
        q2.append((x,y))
        maze[x][y]="."
        path[x][y]=0
  while q1:
    x1,y1=q1.popleft()
    for i in range(4):
      nx1=x1+dx[i]
      ny1=y1+dy[i]
      if 0<=nx1<h and 0<=ny1<w and maze[nx1][ny1]=='.':
        maze[nx1][ny1]=maze[x1][y1]+1
        q1.append((nx1,ny1))
  res="IMPOSSIBLE"
  while q2:
    x2,y2=q2.popleft()
    if x2==0 or x2==h-1 or y2==0 or y2==w-1:
      res=path[x2][y2]+1
      break
    for i in range(4):
      nx2=x2+dx[i]
      ny2=y2+dy[i]
      if nx2<0 or nx2>=h or ny2<0 or ny2>=w:
        continue
      if maze[nx2][ny2]=='#':
        continue
      if path[nx2][ny2]!='.':
        continue
      if maze[nx2][ny2]=='.' or maze[nx2][ny2]>path[x2][y2]+1:
        path[nx2][ny2]=path[x2][y2]+1
        q2.append((nx2,ny2))
  print(res)