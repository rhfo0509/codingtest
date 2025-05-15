T = int(input())

# R -> D -> L -> U 순서
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

for tc in range(1, T + 1):
  N = int(input())

  print(f'#{tc}')
  # N == 1 이면 1 출력
  if N == 1:
    print(1)
    continue
  
  data = [[0] * N for _ in range(N)]
  visited = [[False] * N for _ in range(N)]
  x, y = 0, 0
  d = 0
  num = 1
  while True:

    # 1번 이후 더 이상 갈 곳이 없으면 break
    if visited[x][y]:
      break

    # 갈 수 있다면 숫자 기록 후 방문 체크
    data[x][y] = num
    visited[x][y] = True

    nx, ny = x + dx[d], y + dy[d]

    if nx < 0 or nx >= N or ny < 0 or ny >= N or visited[nx][ny]:
      d = (d + 1) % 4

      # 1. 막혔다면 방향 전환해서 움직이기
      x, y = x + dx[d], y + dy[d]

    else:
      # 2. 안 막혔다면 방향 그대로 움직이기
      x, y = nx, ny

    num += 1

  for i in range(N):
    print(*data[i])