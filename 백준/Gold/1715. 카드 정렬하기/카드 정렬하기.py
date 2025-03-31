import heapq
N = int(input())
h = []
for _ in range(N):
  heapq.heappush(h, int(input()))

result = 0
while True:
  tmp = 0
  if len(h) == 1:
    break
  else:
    tmp = heapq.heappop(h) + heapq.heappop(h)
    result += tmp
    heapq.heappush(h, tmp)

print(result)