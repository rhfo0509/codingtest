N = int(input())
data = [list(map(int, input().split())) for _ in range(N)]
# dp[r][c][state] : 파이프의 끝을 (r, c)로 이동시키는 경우의 수
# state 따라 구분 : 0 - 가로 방향, 1 - 세로 방향, 2 - 대각선 방향
dp = []
for _ in range(N):
  dp.append([[0] * 3 for _ in range(N)])
# 초기값 설정
for i in range(1, N):
  if data[0][i] == 1:
    break
  dp[0][i][0] = 1
for i in range(1, N):
  for j in range(1, N):
    if data[i][j] == 1:
      continue
    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]
    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]
    if data[i - 1][j] == 1 or data[i][j - 1] == 1:
      continue
    dp[i][j][2] = sum(dp[i - 1][j - 1])
print(sum(dp[N - 1][N - 1]))