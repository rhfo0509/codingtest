N = int(input())
E = int(input())
G = [[] for _ in range(N + 1)]
for _ in range(E):
  u, v = map(int, input().split())
  G[u].append(v)
  G[v].append(u)
result = 0
visited = [False] * (N + 1)
def dfs(n):
  global result
  visited[n] = True
  result += 1
  for m in G[n]:
    if not visited[m]:
      dfs(m)
dfs(1)
print(result - 1)