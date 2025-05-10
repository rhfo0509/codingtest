N, M = map(int, input().split())

data = [list(map(int, input().split())) for _ in range(N)]

used = [[False] * M for _ in range(N)]

li = []
result = 0

def dfs(x, y):
  global result

  if len(li) == 4:
    tmp = 0
    for lx, ly in li:
      tmp += data[lx][ly]
    result = max(result, tmp)
    return

  # RIGHT CHECK
  if y + 1 < M and not used[x][y + 1]:
    used[x][y + 1] = True
    li.append((x, y + 1))
    dfs(x, y + 1)
    used[x][y + 1] = False
    li.pop()

  # DOWN CHECK
  if x + 1 < N and not used[x + 1][y]:
    used[x + 1][y] = True
    li.append((x + 1, y))
    dfs(x + 1, y)
    used[x + 1][y] = False
    li.pop()

  # LEFT CHECK
  if y - 1 >= 0 and not used[x][y - 1]:
    used[x][y - 1] = True
    li.append((x, y - 1))
    dfs(x, y - 1)
    used[x][y - 1] = False
    li.pop()

  # UP CHECK
  if x - 1 >= 0 and not used[x - 1][y]:
    used[x - 1][y] = True
    li.append((x - 1, y))
    dfs(x - 1, y)
    used[x - 1][y] = False
    li.pop()

tm = [
  [(0, 1), (1, 0), (1, 1), (1, 2)],
  [(0, 0), (0, 1), (0, 2), (1, 1)],
  [(0, 0), (1, 0), (1, 1), (2, 0)],
  [(0, 1), (1, 0), (1, 1), (2, 1)],
]

def check(i, j, t):
  tmp = 0
  for pos in t:
    x, y = pos
    if i + x >= N or j + y >= M:
      return 0
    tmp += data[i + x][j + y]
    
  return tmp

for i in range(N):
  for j in range(M):
    for t in tm:
      result = max(result, check(i, j, t))

for i in range(N):
  for j in range(M):
    used[i][j] = True
    li.append((i, j))
    dfs(i, j)
    used[i][j] = False
    li.pop()

print(result)