dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
result = 0
def dfs(x, y, depth, alphabet):
  global result
  result = max(result, depth)
  for i in range(4):
    nx, ny = x + dx[i], y + dy[i]
    if 0 <= nx < R and 0 <= ny < C and board[nx][ny] not in alphabet:
        dfs(nx, ny, depth + 1, alphabet + board[nx][ny])
R, C = map(int, input().split())
board = [list(input()) for _ in range(R)]
dfs(0, 0, 1, board[0][0])
print(result)