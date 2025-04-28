from collections import deque
N,K=map(int,input().split())
data=[-1]*100_001
data[N]=0
q=deque([N])
while q:
  x=q.popleft()
  if x==K:
    print(data[x])
    path=[x]
    while x!=N:
      if x%2==0 and data[x//2]==data[x]-1:
        path.append(x//2)
        x//=2
      elif x-1>=0 and data[x-1]==data[x]-1:
        path.append(x-1)
        x-=1
      elif x+1<=100_000 and data[x+1]==data[x]-1:
        path.append(x+1)
        x+=1
    print(*list(reversed(path)))
    break
  if x*2<=100_000 and data[x*2]==-1:
    data[x*2]=data[x]+1
    q.append(x*2)
  if x+1<=100_000 and data[x+1]==-1:
    data[x+1]=data[x]+1
    q.append(x+1)
  if x-1>=0 and data[x-1]==-1:
    data[x-1]=data[x]+1
    q.append(x-1)