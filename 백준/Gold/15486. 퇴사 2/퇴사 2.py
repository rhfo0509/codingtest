import sys
input = sys.stdin.readline

N = int(input())
li = [0] + [tuple(map(int, input().split())) for _ in range(N)]

# i번째 날까지 도달했을 때, 얻을 수 있는 최대 이익
dp = [0] * (N + 2)

T1, P1 = li[1]
if T1 <= N:
  dp[1 + T1] = P1

for i in range(2, N + 1):
  dp[i] = max(dp[i - 1], dp[i])
  Ti, Pi = li[i]

  if i + Ti <= N + 1:
    dp[i + Ti] = max(dp[i] + Pi, dp[i + Ti])

print(max(dp))