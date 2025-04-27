import sys
from collections import deque
input=sys.stdin.readline
while True:
  L,R,C=map(int,input().split())
  if L==0 and R==0 and C==0:
    break
  data=[]
  for _ in range(L):
    data.append([list(input().rstrip()) for _ in range(R)])
    input()
  q=deque([])
  exit=None
  for i in range(L):
    for j in range(R):
      for k in range(C):
        if data[i][j][k]=='S':
          q.append((i,j,k))
          data[i][j][k]=0
        elif data[i][j][k]=='E':
          exit=(i,j,k)
          data[i][j][k]='.'
  dz=[-1,1,0,0,0,0]
  dx=[0,0,-1,1,0,0]
  dy=[0,0,0,0,-1,1]
  res='Trapped!'
  while q:
    pz,px,py=q.popleft()
    if pz==exit[0] and px==exit[1] and py==exit[2]:
      res=f'Escaped in {data[pz][px][py]} minute(s).'
      break
    for i in range(6):
      nz=pz+dz[i]
      nx=px+dx[i]
      ny=py+dy[i]
      if 0<=nz<L and 0<=nx<R and 0<=ny<C and data[nz][nx][ny]=='.':
        data[nz][nx][ny]=data[pz][px][py]+1
        q.append((nz,nx,ny))
  print(res)