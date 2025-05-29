from collections import deque
N, M = map(int, input().split())
G = [[] for _ in range(N + 1)]
for _ in range(M):
  u, v = map(int, input().split())
  G[u].append(v)
  G[v].append(u)
visited = [False] * (N + 1)
def bfs(n):
  q = deque([n])
  visited[n] = True
  while q:
    pn = q.popleft()
    for m in G[pn]:
      if not visited[m]:
        q.append(m)
        visited[m] = True
result = 0
for i in range(1, N + 1):
  if not visited[i]:
    bfs(i)
    result += 1
print(result)