from collections import deque

n, m = map(int, input().split())

# 2차원 리스트의 맵 정보 입력받기
graph = []
for _ in range(n):
    graph.append(list(map(int, input())))

# 상, 하, 좌, 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# BFS로 특정한 노드를 방문한 뒤에 연결된 모든 노드들도 방문
def bfs(x, y):
    q = deque([(x, y)])
    graph[x][y] = 1
    while q:
        vx, vy = q.popleft()
        for k in range(4):
            nx = vx + dx[k]
            ny = vy + dy[k]
            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
                q.append((nx, ny))
                graph[nx][ny] = 1
    return True

# 모든 노드(위치)에 대하여 음료수 채우기
result = 0
for i in range(n):
    for j in range(m):
        # 현재 위치에서 BFS 수행
        if graph[i][j] == 0 and bfs(i, j) == True:
            result += 1

print(result)