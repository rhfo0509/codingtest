from collections import deque
N,M=map(int,input().split())
data=[0]*101
visited=[0]*101
for _ in range(N+M):
  x,y=map(int,input().split())
  data[x]=y
while True:
  q=deque([(1,0)])
  visited[1]=1
  while q:
    pn,pc=q.popleft()
    if pn==100:
      print(pc)
      exit()
    for i in range(6,0,-1):
      nn=pn+i
      if nn>100:
        continue
      if not visited[nn]:
        if data[nn]:
          q.append((data[nn],pc+1))
        else:
          q.append((nn,pc+1))
        visited[nn]=1