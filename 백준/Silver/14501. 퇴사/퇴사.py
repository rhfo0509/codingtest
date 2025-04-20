N = int(input())
li = [0] + [tuple(map(int, input().split())) for _ in range(N)]

# i번째 날까지 상담을 했을 때, 얻을 수 있는 최대 이익
dp = [0] * (N + 1)

T1, P1 = li[1]
if T1 <= N:
  result = dp[1] = P1
else:
  result = dp[1] = 0

for i in range(2, N + 1):
  Ti, Pi = li[i]
  if i + Ti > N + 1:
    continue
  tmp = Pi
  for j in range(1, i):
    Tj, Pj = li[j]
    if j + Tj <= i and dp[j] + Pi > tmp:
      tmp = dp[j] + Pi
  dp[i] = tmp
  if tmp > result:
    result = tmp

print(result)