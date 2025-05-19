from collections import deque
from copy import deepcopy
T = int(input())

def move(data):
  for j in range(W):
    blank = 0
    for i in range(H - 1, -1, -1):
      if data[i][j] == 0:
        blank += 1
      else:
        data[i + blank][j] = data[i][j]
        if blank != 0:
          data[i][j] = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(selected, data):
  for col in selected:
    i = 0
    while i < H:
      if data[i][col] != 0:
        break
      i += 1

    # 벽돌이 하나라도 있다면
    if i != H:
      visited = [[False] * W for _ in range(H)]

      q = deque([(i, col)])
      visited[i][col] = True

      while q:
        px, py = q.popleft()
        value = data[px][py]
        data[px][py] = 0

        for i in range(4):
          for n in range(1, value):
            nx, ny = px + (dx[i] * n), py + (dy[i] * n)
            if 0 <= nx < H and 0 <= ny < W and data[nx][ny] > 0 and not visited[nx][ny]:
              q.append((nx, ny))
              visited[nx][ny] = True

      move(data)
  
  # 모든 과정이 끝나면 벽돌의 개수를 return
  count = 0
  for i in range(H):
    for j in range(W):
      if data[i][j] != 0:
        count += 1

  return count

def dfs(selected):
  global result
  if len(selected) == N:

    count = bfs(selected, deepcopy(data))
    result = min(result, count)
    return
  
  for i in range(W):
    dfs(selected + [i])


for tc in range(1, T + 1):
  N, W, H = map(int, input().split())
  data = [list(map(int, input().split())) for _ in range(H)]
  result = int(1e9)

  # 총 N번동안 몇 번째 열에 구슬을 떨어뜨릴 지 정한다.
  dfs([])
  print(f'#{tc} {result}')