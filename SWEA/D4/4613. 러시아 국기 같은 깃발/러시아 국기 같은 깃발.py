T = int(input())

def dfs(total, selected):
  global result

  if len(selected) == 3:
    if total == N:
      W, B, R = selected
      count = 0

      for i in range(0, W):
        for j in range(M):
          if data[i][j] != 'W':
            count += 1

      for i in range(W, W + B):
        for j in range(M):
          if data[i][j] != 'B':
            count += 1

      for i in range(W + B, W + B + R):
        for j in range(M):
          if data[i][j] != 'R':
            count += 1

      result = min(result, count)
    return
  
  for i in range(1, N + 1):
    dfs(total + i, selected + [i])

for tc in range(1, T + 1):
  N, M = map(int, input().split())
  data = [list(input()) for _ in range(N)]
  visited = [[False] * M for _ in range(N)]
  result = N * M
  dfs(0, [])
  print(f'#{tc} {result}')
