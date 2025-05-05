N, M = map(int, input().split())

data = [list(map(int, input().split())) for _ in range(N)]

cctvs = []
result = 0

for i in range(N):
  for j in range(M):

    if data[i][j] == 0:
      data[i][j] = 7
      result += 1
      
    elif 1 <= data[i][j] <= 5:
      cctvs.append((i, j, data[i][j]))

def up(x, y, selected):

  while x > 0:
    x -= 1

    if data[x][y] == 6:
      break

    elif 1 <= data[x][y] <= 5:
      continue

    else:
      if selected:
        data[x][y] += 1
      else:
        data[x][y] -= 1

def down(x, y, selected):

  while x < N - 1:
    x += 1

    if data[x][y] == 6:
      break

    elif 1 <= data[x][y] <= 5:
      continue

    else:
      if selected:
        data[x][y] += 1
      else:
        data[x][y] -= 1

def left(x, y, selected):

  while y > 0:
    y -= 1

    if data[x][y] == 6:
      break

    elif 1 <= data[x][y] <= 5:
      continue

    else:
      if selected:
        data[x][y] += 1
      else:
        data[x][y] -= 1

def right(x, y, selected):

  while y < M - 1:
    y += 1

    if data[x][y] == 6:
      break

    elif 1 <= data[x][y] <= 5:
      continue

    else:
      if selected:
        data[x][y] += 1
      else:
        data[x][y] -= 1


def backtracking(n):
  global result

  if n == len(cctvs):
    count = 0
    for i in range(N):
      for j in range(M):
        # 7 : 사각지대
        if data[i][j] == 7:
          count += 1

    result = min(result, count)
    return

  posx, posy, value = cctvs[n]

  # 1번
  if value == 1:
    up(posx, posy, True)
    backtracking(n + 1)
    up(posx, posy, False)

    down(posx, posy, True)
    backtracking(n + 1)
    down(posx, posy, False)

    left(posx, posy, True)
    backtracking(n + 1)
    left(posx, posy, False)

    right(posx, posy, True)
    backtracking(n + 1)
    right(posx, posy, False)

  # 2번
  elif value == 2:
    up(posx, posy, True)
    down(posx, posy, True)
    backtracking(n + 1)
    up(posx, posy, False)
    down(posx, posy, False)

    left(posx, posy, True)
    right(posx, posy, True)
    backtracking(n + 1)
    left(posx, posy, False)
    right(posx, posy, False)

  # 3번
  elif value == 3:
    up(posx, posy, True)
    right(posx, posy, True)
    backtracking(n + 1)
    up(posx, posy, False)
    right(posx, posy, False)

    right(posx, posy, True)
    down(posx, posy, True)
    backtracking(n + 1)
    right(posx, posy, False)
    down(posx, posy, False)

    down(posx, posy, True)
    left(posx, posy, True)
    backtracking(n + 1)
    down(posx, posy, False)
    left(posx, posy, False)

    left(posx, posy, True)
    up(posx, posy, True)
    backtracking(n + 1)
    left(posx, posy, False)
    up(posx, posy, False)

  # 4번
  elif value == 4:
    left(posx, posy, True)
    up(posx, posy, True)
    right(posx, posy, True)
    backtracking(n + 1)
    left(posx, posy, False)
    up(posx, posy, False)
    right(posx, posy, False)

    up(posx, posy, True)
    right(posx, posy, True)
    down(posx, posy, True)
    backtracking(n + 1)
    up(posx, posy, False)
    right(posx, posy, False)
    down(posx, posy, False)

    right(posx, posy, True)
    down(posx, posy, True)
    left(posx, posy, True)
    backtracking(n + 1)
    right(posx, posy, False)
    down(posx, posy, False)
    left(posx, posy, False)

    down(posx, posy, True)
    left(posx, posy, True)
    up(posx, posy, True)
    backtracking(n + 1)
    down(posx, posy, False)
    left(posx, posy, False)
    up(posx, posy, False)
  
  else:
    up(posx, posy, True)
    down(posx, posy, True)
    left(posx, posy, True)
    right(posx, posy, True)
    backtracking(n + 1)
    up(posx, posy, False)
    down(posx, posy, False)
    left(posx, posy, False)
    right(posx, posy, False)

backtracking(0)
print(result)