# DFS
n, m = map(int, input().split())

a = [list(input().strip()) for _ in range(n)]

# 상, 하, 좌, 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

cnt = 0

def dfs(i, j):
  d = []
  
  for k in range(4):
    x = i + dx[k]
    y = j + dy[k]
    if 0 <= x < n and 0 <= y < m and a[x][y] == '0':
      d.append([x, y])
  print(d)

  if d:
    for l in d:
      a[l[0]][l[1]] = '1'
      dfs(l[0], l[1])

for i in range(n):
  for j in range(m):
    if a[i][j] == '0':
      a[i][j] = '1'
      cnt += 1
      dfs(i, j)

print(cnt)
