import sys
from collections import deque
input = sys.stdin.readline
N,M,V=map(int,input().split())
G=[[] for _ in range(N+1)]
visited=[False]*(N+1)
for _ in range(M):
  A,B=map(int,input().split())
  G[A].append(B)
  G[B].append(A)
for i in range(N+1):
  G[i].sort()
def dfs(start,arr):
  visited[start]=True
  print(start,end=' ')
  for end in G[start]:
    if not visited[end]:
      dfs(end,arr+[end])
def bfs(start):
  q=deque([start])
  visited[start]=True
  print(start,end=' ')
  while q:
    pstart=q.popleft()
    for end in G[pstart]:
      if not visited[end]:
        q.append(end)
        visited[end]=True
        print(end,end=' ')
dfs(V,[V])
visited=[False]*(N+1)
print()
bfs(V)