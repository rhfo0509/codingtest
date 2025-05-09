from collections import deque
T=10
for tc in range(1, T + 1):
  N, first = map(int, input().split())
  data = list(map(int, input().split()))

  q = deque([])
  # 방문 여부
  visited = [-1] * 101
  from_to = [[] for _ in range(101)]

  for i in range(0, N, 2):
    start, end = data[i], data[i + 1]
    from_to[start].append(end)

  visited[first] = 0
  q.append(first)

  while q:
    p = q.popleft()
    for end in from_to[p]:
      if visited[end] == -1:
        visited[end] = visited[p] + 1
        q.append(end)

  mx = -1
  result = 0
  for i in range(len(visited) - 1, 0, -1):
    if mx < visited[i]:
      mx = visited[i]
      result = i

  print(f'#{tc} {result}')