from collections import deque
N, M = map(int, input().split())
maze = [list(input()) for _ in range(N)]
visited = []
for _ in range(N):
  visited.append([dict() for _ in range(M)])

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, keys):
  q = deque([(x, y, keys)])
  visited[x][y][keys] = 0

  while q:
    px, py, pkeys = q.popleft()

    if maze[px][py] == '1':
      return visited[px][py][pkeys]
    
    for i in range(4):
      nx, ny = px + dx[i], py + dy[i]

      nkeys = pkeys
      
      if nx < 0 or nx >= N or ny < 0 or ny >= M:
        continue

      if maze[nx][ny] == '#':
        continue

      if visited[nx][ny].get(nkeys) is not None:
        continue

      if maze[nx][ny] in 'ABCDEF' and maze[nx][ny].lower() not in nkeys:
        continue

      if maze[nx][ny] in 'abcdef':

        if maze[nx][ny] not in nkeys:
          nkeys += maze[nx][ny]
        
      visited[nx][ny][nkeys] = visited[px][py][pkeys] + 1
      q.append((nx, ny, nkeys))

  return -1

for i in range(N):
  for j in range(M):
    if maze[i][j] == '0':
      print(bfs(i, j, ''))