import sys
from heapq import heappush, heappop
input = sys.stdin.readline
N = int(input())
h = []
for _ in range(N):
  x = int(input())
  if x == 0:
    if not h:
      print(0)
    else:
      print(heappop(h)[1])
  else:
    heappush(h, (abs(x), x))