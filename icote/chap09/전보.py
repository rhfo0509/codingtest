# 한 지점에서 다른 지점까지의 최단 경로 (다익스트라 알고리즘)
# 우선순위 큐를 사용하여 구현해보자.

import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

N, M, C = map(int, input().split())
graph = [[] for _ in range(N + 1)]
distance = [INF] * (N + 1)

for _ in range(M):
  a, b, c = map(int, input().split())
  graph[a].append((b, c))

def dijkstra(start):
  q = []
  heapq.heappush(q, (0, start))
  distance[start] = 0

  while q:
    dist, now = heapq.heappop(q)
    if distance[now] < dist:
      continue
    for i in graph[now]:
      cost = dist + i[1]
      if cost < distance[i[0]]:
        distance[i[0]] = cost
        heapq.heappush(q, (cost, i[0]))

dijkstra(C)

cnt = 0
max_distance = 0
for i in range(1, N + 1):
  if distance[i] != INF:
    cnt += 1
    max_distance = max(max_distance, distance[i])

# 시작 노드는 제외
print(cnt - 1, max_distance)