from collections import deque
field = [list(input()) for _ in range(12)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
  # 뿌요가 있는 위치
  puyos = []

  q = deque([(x, y)])
  visited[x][y] = True
  puyos.append((x, y))

  while q:
    px, py = q.popleft()
    for i in range(4):
      nx = px + dx[i]
      ny = py + dy[i]
      if 0 <= nx < 12 and 0 <= ny < 6 and field[px][py] == field[nx][ny] and not visited[nx][ny]:
        puyos.append((nx, ny))
        visited[nx][ny] = True
        q.append((nx, ny))

  return puyos

# 연쇄 횟수
result = 0
while True:
  visited = [[False] * 6 for _ in range(12)]
  all_puyos = []
  for i in range(12):
    for j in range(6):
      if field[i][j] != '.' and not visited[i][j]:
        puyos = bfs(i, j)
        if len(puyos) >= 4:
          all_puyos += puyos

  if not all_puyos:
    break

  for puyo in all_puyos:
    x, y = puyo
    field[x][y] = '#'

  # 모든 뿌요에 대해 빈 칸의 카운트만큼 아래로 내리기
  for i in range(11, -1, -1):
    for j in range(6):
      # 뿌요라면
      if field[i][j] in 'RGBPY':
        blank_count = 0
        for k in range(11, i, -1):
          if field[k][j] == '#':
            blank_count += 1
        if blank_count >= 1:
          field[i + blank_count][j] = field[i][j]
          field[i][j] = '#'

  # # -> . 되돌리기
  for i in range(12):
    for j in range(6):
      if field[i][j] == '#':
        field[i][j] = '.'
  
  # 연쇄 끝
  result += 1

print(result)
