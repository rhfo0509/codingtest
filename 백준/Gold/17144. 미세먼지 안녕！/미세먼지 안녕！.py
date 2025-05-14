R, C, T = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(R)]
purifier = []
for i in range(R):
  if data[i][0] == -1:
    purifier.append(i)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

time = 0
while time < T:

  # 1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
  tmp = [[0] * C for _ in range(R)]
  for x in range(R):
    for y in range(C):
      if data[x][y] > 0:
        dust = data[x][y]
        spread = data[x][y] // 5
        # (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
        for k in range(4):
          nx = x + dx[k]
          ny = y + dy[k]
          # 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
          if 0 <= nx < R and 0 <= ny < C and data[nx][ny] != -1:
            # 확산되는 양은 Ar,c/5이고 소수점은 버린다. 즉, ⌊Ar,c/5⌋이다.
            tmp[nx][ny] += spread
            dust -= spread
        # (r, c)에 남은 미세먼지의 양은 Ar,c - ⌊Ar,c/5⌋×(확산된 방향의 개수) 이다.
        data[x][y] = dust

  for x in range(R):
    for y in range(C):
      data[x][y] += tmp[x][y]

  # 2. 공기청정기가 작동한다.
  upx, dpx = purifier

  # 위쪽 공기청정기의 바람은 반시계방향으로 순환하고
  for i in range(upx - 1, 0, -1):
    data[i][0] = data[i - 1][0]

  for i in range(0, C - 1):
    data[0][i] = data[0][i + 1]

  for i in range(0, upx):
    data[i][C - 1] = data[i + 1][C - 1]

  for i in range(C - 1, 1, -1):
    data[upx][i] = data[upx][i - 1]

  # 공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
  data[upx][1] = 0

  # 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
  for i in range(dpx + 1, R - 1):
    data[i][0] = data[i + 1][0]

  for i in range(0, C - 1):
    data[R - 1][i] = data[R - 1][i + 1]

  for i in range(R - 1, dpx, -1):
    data[i][C - 1] = data[i - 1][C - 1]

  for i in range(C - 1, 1, -1):
    data[dpx][i] = data[dpx][i - 1]

  data[dpx][1] = 0
  
  time += 1

result = 0
for x in range(R):
  for y in range(C):
    if data[x][y] > 0:
      result += data[x][y]

print(result)