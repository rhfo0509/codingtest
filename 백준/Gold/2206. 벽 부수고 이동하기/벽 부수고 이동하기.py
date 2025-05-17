from collections import deque
N, M = map(int, input().split())

maze = [list(map(int, input())) for _ in range(N)]

# visited[x][y][broken]
# 벽을 부수지 않은 상태로 특정 칸을 방문한 경우(0)와
# 이미 한 번 벽을 부순 상태로 특정 칸을 방문한 경우(1)를 구분
visited = []
for _ in range(N):
  visited.append([[0] * 2 for _ in range(M)])

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, broken):
  q = deque([(x, y, broken)])
  visited[x][y][broken] = 1

  while q:
    px, py, p_broken = q.popleft()

    if px == N - 1 and py == M - 1:

      return max(visited[px][py])

    for i in range(4):
      nx, ny = px + dx[i], py + dy[i]

      if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny][p_broken]:

        # 벽이 아닌 경우
        if maze[nx][ny] == 0:
          visited[nx][ny][p_broken] = visited[px][py][p_broken] + 1
          q.append((nx, ny, p_broken))

        # 벽인데, 아직 안 부순 경우
        elif maze[nx][ny] != 0 and p_broken == 0:
          visited[nx][ny][1] = visited[px][py][0] + 1
          q.append((nx, ny, 1))

        # 벽인데, 이미 한 번 부쉈을 경우 갈 수 없으므로 큐에 넣지 않는다.
  
  return -1

print(bfs(0, 0, 0))