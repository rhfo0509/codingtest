from collections import deque

T = int(input())

dx = [-2, -2, -1, -1, 1, 1, 2, 2]
dy = [-1, 1, -2, 2, -2, 2, -1, 1]

for _ in range(T):
  N = int(input())

  data = [[-1] * N for _ in range(N)]
  visited = [[False] * N for _ in range(N)]

  start_x, start_y = map(int, input().split())
  end_x, end_y = map(int, input().split())
  q = deque([(start_x, start_y)])
  data[start_x][start_y] = 0

  while q:
    px, py = q.popleft()

    if px == end_x and py == end_y:
      print(data[px][py])
      break

    for i in range(8):
      nx = px + dx[i]
      ny = py + dy[i]

      if 0 <= nx < N and 0 <= ny < N and data[nx][ny] == -1:
        data[nx][ny] = data[px][py] + 1
        q.append((nx, ny))