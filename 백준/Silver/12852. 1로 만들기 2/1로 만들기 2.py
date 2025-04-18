N = int(input())

dp = [0] * (N + 1)

dp[1] = 0

if N >= 2:
  dp[2] = 1

if N >= 3:
  dp[3] = 1

process = [0, 1, 2, 3]

for i in range(4, N + 1):
  # tmp = 1 이면 -1
  # tmp = 2 이면 // 2
  # tmp = 3 이면 // 3
  dp[i] = dp[i - 1] + 1
  tmp = 1

  if i % 2 == 0:
    if dp[i] >= dp[i // 2] + 1:
      tmp = 2
      dp[i] = dp[i // 2] + 1

  if i % 3 == 0:
    if dp[i] >= dp[i // 3] + 1:
      tmp = 3
      dp[i] = dp[i // 3] + 1

  process.append(tmp)

print(dp[N])

while N != 1:
  print(N, end=' ')

  if process[N] == 1:
    N -= 1
  elif process[N] == 2:
    N //= 2
  else:
    N //= 3

print(1)