T = int(input())

dx = [1, 0, 1, 1]
dy = [0, 1, 1, -1]

def check(x, y):
  for i in range(4):
    count = 1
    nx, ny = x, y
    while True:
      nx += dx[i]
      ny += dy[i]

      if nx < 0 or nx >= N or ny < 0 or ny >= N or data[nx][ny] == '.':
        break

      count += 1

      if count == 5:
        return True
      
  return False

for tc in range(1, T + 1):
  N = int(input())
  data = [list(input()) for _ in range(N)]

  result = 'NO'
  for i in range(N):
    for j in range(N):
      if data[i][j] == 'o':
        if check(i, j):
          result = 'YES'
          break
    if result == 'YES':
      break
  print(f'#{tc} {result}')
