N = int(input())
A = [0] + list(map(int, input().split()))

if N == 1:
  print(A[1])
  exit()

# i번째 인덱스를 선택할 때, 합이 가장 큰 증가하는 부분 수열의 합
dp = [0] * (N + 1)

res = dp[1] = A[1]

for i in range(2, N + 1):
  tmp = A[i]
  for j in range(i - 1, 0, -1):
    if A[j] < A[i] and dp[j] + A[i] > tmp:
      tmp = dp[j] + A[i]
  dp[i] = tmp
  
  if dp[i] > res:
    res = dp[i]

print(res)