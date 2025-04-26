from collections import deque
F,S,G,U,D=map(int,input().split())
data=[-1]*1_000_001
q=deque([S])
data[S]=0
while q:
  x=q.popleft()
  if x==G:
    print(data[x])
    exit()
  if x+U<=F and data[x+U]==-1:
    data[x+U]=data[x]+1
    q.append(x+U)
  if x-D>=1 and data[x-D]==-1:
    data[x-D]=data[x]+1
    q.append(x-D)
print('use the stairs')