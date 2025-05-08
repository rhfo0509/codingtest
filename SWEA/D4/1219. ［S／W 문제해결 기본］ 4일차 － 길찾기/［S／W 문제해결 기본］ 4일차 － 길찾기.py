from collections import deque
T=10
for _ in range(T):
  N, M = map(int, input().split())
  li = list(map(int, input().split()))

  data1 = [-1] * 100
  data2 = [-1] * 100
  visited1 = [False] * 100
  visited2 = [False] * 100

  for i in range(0, M * 2, 2):
    start, end = li[i], li[i + 1]
    if data1[start] == -1:
      data1[start] = end
    else:
      data2[start] = end

  result = 0

  # bfs
  q = deque([0])

  while q:
    node = q.popleft()

    if node == 99:
      result = 1
      break

    if data1[node] != -1:
      q.append(data1[node])

    if data2[node] != -1:
      q.append(data2[node])

  print(f'#{N} {result}')
