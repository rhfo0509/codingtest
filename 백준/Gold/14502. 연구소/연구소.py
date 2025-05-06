# 14502. 연구소

from collections import deque
import copy
N, M = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(N)]
# 안전 영역의 최대 크기
result = 0

# 빈 칸의 위치 정보가 담겨있는 리스트
li = []
# 바이러스의 위치 정보가 담겨있는 큐
q = deque([])
for i in range(N):
  for j in range(M):
    if data[i][j] == 0:
      li.append((i, j))
    elif data[i][j] == 2:
      q.append((i, j))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 1. 먼저 벽부터 3개 세운다. (dfs-combination)
selected = []
def dfs(start):
  global result
  if len(selected) == 3:
    count = 0
    tmp = copy.deepcopy(data)
    tmp_q = copy.deepcopy(q)

    # 2. 바이러스를 전파한다. (bfs)
    while tmp_q:
      px, py = tmp_q.popleft()

      for i in range(4):
        nx = px + dx[i]
        ny = py + dy[i]

        if 0 <= nx < N and 0 <= ny < M and tmp[nx][ny] == 0:
          tmp_q.append((nx, ny))
          tmp[nx][ny] = 2
  
    # 3. 안전 구역을 카운트한다.
    for i in range(N):
      for j in range(M):
        if tmp[i][j] == 0:
          count += 1

    result = max(result, count)
    return
  
  for i in range(start, len(li)):
    x, y = li[i]
    data[x][y] = 1
    selected.append(li[i])
    dfs(i + 1)
    data[x][y] = 0
    selected.pop()

dfs(0)
print(result)