from collections import deque
N, K = map(int, input().split())

# (시간, 위치)
q = deque([(0, N)])
visited = [False] * 100_001

while q:
  t, l = q.popleft()

  if l == K:
    print(t)
    break

  if l - 1 >= 0 and not visited[l - 1]:
    q.append((t + 1, l - 1))
    visited[l - 1] = True

  if l + 1 <= 100_000 and not visited[l + 1]:
    q.append((t + 1, l + 1))
    visited[l + 1] = True

  if l * 2 <= 100_000 and not visited[l * 2]:
    q.append((t + 1, l * 2))
    visited[l * 2] = True