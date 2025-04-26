from collections import deque
T=int(input())
dx=[-1,1,0,0]
dy=[0,0,-1,1]
for _ in range(T):
  M,N,K=map(int,input().split())
  data=[[0]*N for _ in range(M)]
  for _ in range(K):
    X,Y=map(int,input().split())
    data[X][Y]=1
  visited=[[False]*N for _ in range(M)]
  res=0
  for x in range(M):
    for y in range(N):
      if data[x][y]==1 and not visited[x][y]:
        q=deque([(x,y)])
        while q:
          px,py=q.popleft()
          for i in range(4):
            nx=px+dx[i]
            ny=py+dy[i]
            if 0<=nx<M and 0<=ny<N and data[nx][ny]==1 and not visited[nx][ny]:
              visited[nx][ny]=True
              q.append((nx,ny))
        res+=1
  print(res)