import sys, heapq
input = sys.stdin.readline

N = int(input())
classes = []
cnt = 0
result = 0

for i in range(N):
  start, end = map(int, input().split())
  classes.append((end, start))

classes.sort(key=lambda x: (x[1], x[0]))

heap = []

for i in range(N):
  while heap and heap[0][0] <= classes[i][1]:
    heapq.heappop(heap)
    cnt -= 1
  heapq.heappush(heap, classes[i])
  cnt += 1
  result = max(cnt, result)

print(result)