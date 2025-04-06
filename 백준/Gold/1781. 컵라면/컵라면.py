import sys, heapq
input = sys.stdin.readline

n = int(input())

li = []
day = 0

for i in range(n):
  deadline, ramen = map(int, input().split())

  if deadline > day:
    day = deadline
  li.append((deadline, ramen))

li.sort(reverse=True)

res = 0
idx = 0
heap = []

while day > 0:
  while idx < n and li[idx][0] >= day:
    heapq.heappush(heap, -li[idx][1])
    idx += 1
  if heap:
    res += -heapq.heappop(heap)
  day -= 1

print(res)