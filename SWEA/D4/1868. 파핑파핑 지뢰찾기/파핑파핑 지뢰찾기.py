from collections import deque
T = int(input())

dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, 1, -1, -1, 1]

def bfs(x, y):
  q = deque([(x, y)])
  
  while q:
    px, py = q.popleft()

    for i in range(8):
      nx, ny = px + dx[i], py + dy[i]
      if 0 <= nx < N and 0 <= ny < N and data[nx][ny] == '.':
    
        mine = count_mine(nx, ny)
        if mine == 0:
          q.append((nx, ny))
      
        data[nx][ny] = mine
    
def count_mine(x, y):

  mine = 8
  for i in range(8):
    nx, ny = x + dx[i], y + dy[i]
    if nx < 0 or nx >= N or ny < 0 or ny >= N:
      mine -= 1
      continue
    if data[nx][ny] != '*':
      mine -= 1

  return mine

for tc in range(1, T + 1):
  N = int(input())
  data = [list(input()) for _ in range(N)]
  result = 0

  for i in range(N):
    for j in range(N):
      if data[i][j] == '.' and count_mine(i, j) == 0:
        data[i][j] = 0
        bfs(i, j)
        result += 1

  for i in range(N):
    for j in range(N):
      if data[i][j] == '.':
        data[i][j] = count_mine(i, j)
        result += 1

  print(f'#{tc} {result}')
