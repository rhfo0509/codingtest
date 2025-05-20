from collections import deque

N, M = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def melt():
    tmp = [[0] * M for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if data[i][j] > 0:
                for k in range(4):
                    if data[i + dx[k]][j + dy[k]] == 0:
                        tmp[i][j] += 1

    for i in range(N):
        for j in range(M):
            if data[i][j] > 0:
                data[i][j] = max(0, data[i][j] - tmp[i][j])


def bfs(x, y):

    q = deque([(x, y)])
    visited[x][y] = True

    while q:
        px, py = q.popleft()
        for i in range(4):
            nx, ny = px + dx[i], py + dy[i]
            if not visited[nx][ny] and data[nx][ny] > 0:
                visited[nx][ny] = True
                q.append((nx, ny))

year = 0
while True:
    count = 0
    visited = [[False] * M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if data[i][j] > 0 and not visited[i][j]:
                bfs(i, j)
                count += 1

    if count == 0:
        print(0)
        break
    
    elif count > 1:
        print(year)
        break

    melt()
    year += 1