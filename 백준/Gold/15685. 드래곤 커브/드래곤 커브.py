N = int(input())

# (→, ↑, ←, ↓) - python 좌표 기준
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

# x(ㅣ), y(ㅡ)
grid = [[0] * 101 for _ in range(101)]

for _ in range(N):
  # x와 y는 드래곤 커브의 시작 점, d는 시작 방향, g는 세대이다.
  x, y, d, g = map(int, input().split())
  # python 좌표 기준
  x, y = y, x

  # 0세대
  data = [(x, y), (x + dx[d], y + dy[d])]
  
  for _ in range(1, g + 1):
    # 끝 점의 좌표
    end_point = data[-1]
    epx, epy = end_point

    pos = []
    # 끝 점을 제외한 모든 좌표를 (0, 0) 기준으로 설정
    # 이 때 역순으로 순회 (중요)
    for px, py in data[::-1][1:]:
      pos.append((px - epx, py - epy))

    # 90도 회전 
    # 기존 좌표를 (x', y'), 회전 후 좌표를 (x, y)라고 한다면
    # (x, y) <- (y', -x')
    # 그리고 다시 좌표를 end point 기준으로 설정
    for i in range(len(pos)):
      px, py = pos[i]
      pos[i] = (py + epx, -px + epy)

    data += pos

  for gx, gy in data:
    if 0 <= gx <= 100 and 0 <= gy <= 100: 
      grid[gx][gy] = 1

# for i in range(101):
#   for j in range(101):
#     print(grid[i][j],end='')
#   print()

result = 0
for i in range(1, 101):
  for j in range(1, 101):
    if grid[j - 1][i - 1] == 1 and grid[j - 1][i] == 1 and grid[j][i - 1] == 1 and grid[j][i] == 1:
      result += 1
print(result)