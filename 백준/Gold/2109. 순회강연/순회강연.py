import sys
input = sys.stdin.readline

n = int(input())

li = []
result = 0

visited = [False] * 10_001

for i in range(n):
  li.append(list(map(int, input().split())))

li.sort(reverse=True)

for p, d in li:
  while visited[d]:
    d -= 1

    if d == 0:
      break

  if d != 0:
    visited[d] = True
    result += p

print(result)