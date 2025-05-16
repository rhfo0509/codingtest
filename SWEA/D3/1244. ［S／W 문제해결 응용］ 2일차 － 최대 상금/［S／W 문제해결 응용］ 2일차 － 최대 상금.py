# 최대 상금
# 백트래킹
from itertools import combinations

def backtracking(count, data):
  num = int(''.join(data))

  if (num, count) in visited:
    return

  visited.add((num, count))

  if count == N:
    result.add(num)
    return
  
  for x, y in list(combinations(range(0, len(data)), 2)):
    data[x], data[y] = data[y], data[x]
    backtracking(count + 1, data)
    data[x], data[y] = data[y], data[x]

T = int(input())

for tc in range(1, T + 1):
  data, N = input().split()

  N = int(N)
  data = list(data)
  visited = set()
  result = set()

  backtracking(0, data)

  print(f'#{tc} {max(result)}')