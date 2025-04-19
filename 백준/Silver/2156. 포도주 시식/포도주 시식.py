N = int(input())
dp = [[0, 0] for _ in range(N + 1)]

res = dp[1][1] = int(input())

if N >= 2:
  dp[2][0] = int(input())
  dp[2][1] = dp[2][0] + dp[1][1]
  res = dp[2][1]

for i in range(3, N + 1):
  # [i-1 선택X + max(dp[i-2]), i-1 선택 + i-2 선택X]
  S = int(input())
  dp[i][0] = max(dp[i - 1][0], max(dp[i - 2]) + S)
  dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + S)

  if res < max(dp[i]):
    res = max(dp[i])

print(res)