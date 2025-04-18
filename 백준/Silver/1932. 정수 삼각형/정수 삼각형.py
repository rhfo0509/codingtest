import sys
input = sys.stdin.readline

n = int(input())

dp = [[0] * n for _ in range(n + 1)]

dp[1] = [int(input())]

if n >= 2:
  n1, n2 = map(int, input().split())
  dp[2] = [dp[1][0] + n1, dp[1][0] + n2]

for i in range(3, n + 1):
  for j, num in enumerate(map(int, input().split())):
    if j == 0:
      dp[i][j] = dp[i - 1][j] + num
    elif j == i - 1:
      dp[i][j] = dp[i - 1][j - 1] + num
    else:
      dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + num

print(max(dp[n]))