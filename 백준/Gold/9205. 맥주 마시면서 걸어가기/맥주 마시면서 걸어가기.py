from collections import deque
t=int(input())
def bfs(x,y):
  q=deque([(x,y)])
  while q:
    px,py=q.popleft()
    if (px,py)==dest[-1]:
      return 'happy'
    for i in range(n+1):
      cx,cy=dest[i]
      if abs(px-cx)+abs(py-cy)<=1000 and not visited[i]:
        visited[i]=True
        q.append((cx,cy))
  return 'sad'

for _ in range(t):
  n=int(input())
  home=tuple(map(int,input().split()))
  dest=list(tuple(map(int,input().split())) for _ in range(n))
  dest.append(tuple(map(int,input().split())))
  visited=[False]*(n+1)
  hx,hy=home
  print(bfs(hx, hy))