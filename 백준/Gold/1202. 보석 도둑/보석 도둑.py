import sys, heapq
input = sys.stdin.readline

# N: 보석 개수, K: 가방 개수
N, K = map(int, input().split())

jewels = []
for i in range(N):
  # M: 보석 무게, V: 보석 가격
  M, V = map(int, input().split())
  jewels.append((M, V))

jewels.sort()

bags = []
for i in range(K):
  # C: 가방 무게
  C = int(input())
  bags.append(C)

bags.sort()

idx = 0
res = 0
heap = []
for bag in bags:
  while idx < N and jewels[idx][0] <= bag:
    heapq.heappush(heap, -jewels[idx][1])
    idx += 1

  if heap:
    res += -heapq.heappop(heap)


print(res)