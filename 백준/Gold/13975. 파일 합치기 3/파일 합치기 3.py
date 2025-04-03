import heapq
T = int(input())
for _ in range(T):
  K = int(input())
  file = list(map(int, input().split()))
  heapq.heapify(file)
  result = 0
  while len(file) != 1:
    tmp = heapq.heappop(file) + heapq.heappop(file)
    result += tmp
    heapq.heappush(file, tmp)
  print(result)