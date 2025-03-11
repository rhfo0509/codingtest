n, m = map(int, input().split())

a, b, d = map(int, input().split())

board = []
visited = [[0] * m for _ in range(n)]  # 방문 여부 체크 배열

for i in range(n):
    board.append(list(map(int, input().split())))

# 처음 위치 방문 처리
cnt = 1
visited[a][b] = 1  

# 방향 벡터 (북, 동, 남, 서)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def turn_left(d):
    return (d - 1) % 4

turn_count = 0  # 회전 횟수 체크
while True:
    d = turn_left(d)
    nx = a + dx[d]
    ny = b + dy[d]
    
    # 가보지 않은 칸이 있다면 이동
    if visited[nx][ny] == 0 and board[nx][ny] == 0:
        visited[nx][ny] = 1
        a, b = nx, ny
        cnt += 1
        turn_count = 0  # 회전 횟수 초기화
        continue
    else:
        turn_count += 1
    
    # 네 방향 모두 갈 곳이 없을 때
    if turn_count == 4:
        nx = a - dx[d]
        ny = b - dy[d]
        
        # 뒤쪽이 바다가 아니라면 이동 (방문 여부 신경 X)
        if board[nx][ny] == 0:
            a, b = nx, ny
        else:
            break  # 뒤쪽이 바다라면 종료
        
        turn_count = 0  # 다시 이동 후 초기화

print(cnt)

