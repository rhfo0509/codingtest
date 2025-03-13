from collections import deque

n, m = map(int, input().split())

graph = []
for _ in range(n):
  graph.append(list(map(int, input())))

# 상, 하, 좌, 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 원리는 bfs를 수행하면서서
# '새롭게 방문하는 노드'의 값을 1씩 증가시키는 것이다.
def bfs(x, y):
  # 도착 여부
  q = deque([(x, y)])
  while q:
    vx, vy = q.popleft()
    print(vx, vy)
    for k in range(4):
      nx = vx + dx[k]
      ny = vy + dy[k]
      if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1:
        q.append((nx, ny))
        graph[nx][ny] = graph[vx][vy] + 1
  return graph[n-1][m-1]

# 최단 거리 탐색 문제: BFS
print(bfs(0, 0))