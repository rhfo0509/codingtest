from collections import deque
N, M = map(int, input().split())
data = [list(input()) for _ in range(N)]

# 빨간 구슬의 좌표
rx, ry = -1, -1
# 파란 구슬의 좌표
bx, by = -1, -1
# 구멍의 좌표
ox, oy = -1, -1

for i in range(N):
  for j in range(M):
    if data[i][j] == 'R':
      # R 좌표 저장 후 보드에서 제거
      rx, ry = i, j
      data[i][j] = '.'
    elif data[i][j] == 'B':
      # B 좌표 저장 후 보드에서 제거
      bx, by = i, j
      data[i][j] = '.'
    elif data[i][j] == 'O':
      ox, oy = i, j

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

result = -1

def move(d, rx, ry, bx, by):
  goal = False
  # U(0)이면서 rx>bx인 경우
  # D(1)이면서 rx<bx인 경우
  # L(2)이면서 ry>by인 경우
  # R(3)이면서 ry<by인 경우

  if (d == 0 and rx > bx) or (d == 1 and rx < bx) or (d == 2 and ry > by) or (d == 3 and ry < by):
    while True:
      if data[bx + dx[d]][by + dy[d]] == '#':
        break
      if data[bx + dx[d]][by + dy[d]] == 'O':
        return False
      bx += dx[d]
      by += dy[d]
    data[bx][by] = 'B'
    while True:
      if data[rx + dx[d]][ry + dy[d]] in '#B':
        break
      if data[rx + dx[d]][ry + dy[d]] == 'O':
        data[bx][by] = '.'
        return True
      rx += dx[d]
      ry += dy[d]
    data[bx][by] = '.'
  
  else:
    while True:
      if data[rx + dx[d]][ry + dy[d]] == '#':
        break
      if data[rx + dx[d]][ry + dy[d]] == 'O':
        goal = True
        break
      rx += dx[d]
      ry += dy[d]
    if not goal:
      data[rx][ry] = 'R'
    while True:
      # goal = True인 경우
      if goal:
        # R 제외
        if data[bx + dx[d]][by + dy[d]] == '#':
          break
        if data[bx + dx[d]][by + dy[d]] == 'O':
          data[rx][ry] = '.'
          return False
        bx += dx[d]
        by += dy[d]
        continue

      if data[bx + dx[d]][by + dy[d]] in '#R':
        break
      if data[bx + dx[d]][by + dy[d]] == 'O':
        data[rx][ry] = '.'
        return False
      bx += dx[d]
      by += dy[d]
    data[rx][ry] = '.'

  if goal:
    return True
  
  # for i in range(N):
  #   for j in range(M):
  #       print(data[i][j],end='')
  #   print()
  # print()
  return rx, ry, bx, by

# 0 : 실패
# 1 : 성공
# 2 : 진행중
def bfs(rx, ry, bx, by, count):
  visited.add((rx, ry, bx, by))
  q = deque([(rx, ry, bx, by, count)])

  while q:
    prx, pry, pbx, pby, pcount = q.popleft()

    if pcount == 10:
      return -1

    for i in range(4):
      flag = move(i, prx, pry, pbx, pby)

      if flag == 0:
        continue
      
      elif flag == 1:
        return pcount + 1
      
      else:
        nrx, nry, nbx, nby = flag
        if (nrx, nry, nbx, nby) not in visited:
          visited.add((nrx, nry, nbx, nby))
          q.append((nrx, nry, nbx, nby, pcount + 1))

  return -1


# 방문 여부
visited = set()

result = bfs(rx, ry, bx, by, 0)

print(result)