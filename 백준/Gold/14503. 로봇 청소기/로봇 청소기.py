# 14503. 시뮬레이션(dfs + 백트래킹)
N, M = map(int, input().split())

r, c, d = map(int, input().split())

data = [list(map(int, input().split())) for _ in range(N)]

result = 0

# 북(0), 동(1), 남(2), 서(3)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def dfs(x, y, d):
  global result
  # 현재 칸이 아직 청소되지 않은 경우, 
  if data[x][y] == 0:
    # 현재 칸을 청소한다. (청소됨 : 2)
    data[x][y] = 2
    result += 1

  # 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 
  if data[x][y] == 1:
    print(result)
    # 작동을 멈춘다.
    exit()
  
  # 현재 칸의 주변 4칸 중
  for _ in range(4):
    d = (d - 1) % 4
    # 청소되지 않은 빈 칸이 있는 경우
    if data[x + dx[d]][y + dy[d]] == 0:
      # 반시계 방향으로 90' 회전한다.
      # 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
      dfs(x + dx[d], y + dy[d], d)

  # 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
  # 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진한다.
  dfs(x - dx[d], y - dy[d], d)

dfs(r, c, d)