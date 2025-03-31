import heapq
n, m = map(int, input().split())
h = list(map(int, input().split()))

heapq.heapify(h)

for _ in range(m):
  r = heapq.heappop(h) + heapq.heappop(h)
  heapq.heappush(h, r)
  heapq.heappush(h, r)

print(sum(h))