import sys, heapq
input = sys.stdin.readline

N = int(input())
classes = []
for _ in range(N):
  _, start, end = map(int, input().split())
  classes.append((start, end))

classes.sort()

heap = []
result = cnt = 0
for start, end in classes:
  while heap and heap[0][0] <= start:
    heapq.heappop(heap)
    cnt -= 1
  heapq.heappush(heap, (end, start))
  cnt += 1
  result = max(result, cnt)

print(result)