# 집의 개수
N = int(input())

# 현재까지의 집을 칠하는 비용의 최솟값
dp = [[0, 0, 0] for _ in range(N + 1)]

dp[1] = list(map(int, input().split()))

for i in range(2, N + 1):
  cur = list(map(int, input().split()))
  # i번째 집에서 R을 선택하는 경우
  dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + cur[0]
  # i번째 집에서 G을 선택하는 경우
  dp[i][1] = min(dp[i - 1][2], dp[i - 1][0]) + cur[1]
  # i번째 집에서 B을 선택하는 경우
  dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + cur[2]

result = min(dp[N])

print(result)
