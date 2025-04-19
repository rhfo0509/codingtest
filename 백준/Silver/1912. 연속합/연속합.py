n = int(input())
seq = [0] + list(map(int, input().split()))

if n == 1:
  print(seq[1])
  exit()

if n == 2:
  print(max(seq[1], seq[2], seq[1] + seq[2]))
  exit()

# i번째를 선택하지 않을 때의 최댓값
dp = [0] * (n + 1)

dp[1] = 0
res = dp[2] = seq[1]

for i in range(3, n + 1):
  dp[i] = max(dp[i - 1] + seq[i - 1], seq[i - 1])

  if dp[i] > res:
    res = dp[i]

# 마지막도 비교해야 한다.
last = max(dp[n] + seq[n], seq[n])

print(max(res, last))