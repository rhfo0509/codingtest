# 1. A에서 K로 가는 최단 거리
# 2. K에서 X로 가는 최단 거리
# 두 가지 경우 각각에 대해 최단 거리를 구해야 하므로, 플로이드 워셜 알고리즘을 사용해야 한다.

INF = int(1e9)
N, M = map(int, input().split())
graph = [[INF] * (N + 1) for _ in range(N + 1)]

for x in range(1, N + 1):
  for y in range(1, N + 1):
    if x == y:
      graph[x][y] = 0

for _ in range(M):
  a, b = map(int, input().split())
  graph[a][b] = 1
  graph[b][a] = 1

X, K = map(int, input().split())
# 플로이드 워셜 알고리즘
for k in range(1, N + 1):
  for a in range(1, N + 1):
    for b in range(1, N + 1):
      graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

d = graph[1][K] + graph[K][X]
if d >= INF:
  print(-1)
else:
  print(d)
