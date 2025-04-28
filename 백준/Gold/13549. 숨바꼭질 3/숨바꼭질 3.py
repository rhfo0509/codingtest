from collections import deque
N,K=map(int,input().split())
data=[-1]*100_001
data[N]=0
q=deque([N])
while q:
  x=q.popleft()
  if x*2<=100_000 and data[x*2]==-1:
    data[x*2]=data[x]
    q.appendleft(x*2)
  if x-1>=0 and data[x-1]==-1:
    data[x-1]=data[x]+1
    q.append(x-1)
  if x+1<=100_000 and data[x+1]==-1:
    data[x+1]=data[x]+1
    q.append(x+1)
print(data[K])