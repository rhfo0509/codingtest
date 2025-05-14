T = int(input())

dx = [-1, 1, 0, 0, -1, 1, -1, 1]
dy = [0, 0, -1, 1, -1, 1, 1, -1]
for tc in range(1, T + 1):
  N, M = map(int, input().split())
  data = [[0] * (N + 1) for _ in range(N + 1)]

  mid = N // 2
  data[mid][mid] = data[mid + 1][mid + 1] = 2
  data[mid][mid + 1] = data[mid + 1][mid] = 1

  for _ in range(M):
    x, y, c = map(int, input().split())
    data[x][y] = c

    # 상, 하, 좌, 우, 좌상, 우하, 좌하, 우상
    for i in range(8):
      nx = x + dx[i]
      ny = y + dy[i]

      if nx <= 0 or nx > N or ny <= 0 or ny > N or data[nx][ny] != 3 - c:
        continue

      change = [(nx, ny)]
      while True:
        nx += dx[i]
        ny += dy[i]

        if nx <= 0 or nx > N or ny <= 0 or ny > N or data[nx][ny] == 0:
          change = []
          break

        if data[nx][ny] == c:
          break
        else:
          change.append((nx, ny))
        
      for cx, cy in change:
        data[cx][cy] = c
  
  bc, wc = 0, 0
  for i in range(1, N + 1):
    for j in range(1, N + 1):
      if data[i][j] == 1:
        bc += 1
      elif data[i][j] == 2:
        wc += 1
  print(f'#{tc} {bc} {wc}')
