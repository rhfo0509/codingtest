T = int(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y, depth, num):
  if depth == 7:
    result.add(num)
    return

  for i in range(4):
    nx, ny = x + dx[i], y + dy[i]
    if 0 <= nx < 4 and 0 <= ny < 4:
      dfs(nx, ny, depth + 1, num + grid[nx][ny])

for tc in range(1, T + 1):
  grid = [input().split() for _ in range(4)]
  result = set()

  for i in range(4):
    for j in range(4):
      dfs(i, j, 1, grid[i][j])

  print(f'#{tc} {len(result)}')
