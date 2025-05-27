from collections import deque
n,m=map(int,input().split())
g=[[] for _ in range(n+1)]
for _ in range(m):
  a,b=map(int,input().split())
  g[a].append(b)
  g[b].append(a)

def bfs(i):
  v=[-1]*(n+1)
  q=deque([i])
  v[i]=0
  while q:
    pi=q.popleft()
    for j in g[pi]:
      if v[j]==-1:
        q.append(j)
        v[j]=v[pi]+1
  return sum(v)+1

mn=int(1e9)
res=-1
for i in range(1,n+1):
  t=bfs(i)
  if t<mn:
    mn=t
    res=i
print(res)