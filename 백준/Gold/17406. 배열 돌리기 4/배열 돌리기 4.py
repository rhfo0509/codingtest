from copy import deepcopy
N, M, K = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
R = [list(map(int, input().split())) for _ in range(K)]
used = [False] * K

def rotate(selected, data):
  for r, c, s in selected:
    # 0-based index
    r, c = r - 1, c - 1
    for d in range(1, s + 1):
      tmp = data[r - d][c - d]

      # ↑
      for i in range(r - d, r + d):
        data[i][c - d] = data[i + 1][c - d]

      # ←
      for i in range(c - d, c + d):
        data[r + d][i] = data[r + d][i + 1]

      # ↓
      for i in range(r + d, r - d, -1):
        data[i][c + d] = data[i - 1][c + d]

      # →
      for i in range(c + d, c - d + 1, -1):
        data[r - d][i] = data[r - d][i - 1]

      data[r - d][c - d + 1] = tmp

def calculate(data):
  mn = int(1e9)
  for i in range(N):
    mn = min(mn, sum(data[i]))
  return mn

def dfs(selected):
  global result
  if len(selected) == K:
    cA = deepcopy(A)
    rotate(selected, cA)
    result = min(result, calculate(cA))
    return

  for i in range(K):
    if not used[i]:
      used[i] = True
      dfs(selected + [R[i]])
      used[i] = False

result = int(1e9)
dfs([])
print(result)