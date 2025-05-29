import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
N, M = map(int, input().split())
G = [[] for _ in range(N + 1)]
for _ in range(M):
  u, v = map(int, input().split())
  G[u].append(v)
  G[v].append(u)
visited = [False] * (N + 1)
def dfs(n):
  visited[n] = True
  for m in G[n]:
    if not visited[m]:
      dfs(m)
result = 0
for i in range(1, N + 1):
  if not visited[i]:
    dfs(i)
    result += 1
print(result)