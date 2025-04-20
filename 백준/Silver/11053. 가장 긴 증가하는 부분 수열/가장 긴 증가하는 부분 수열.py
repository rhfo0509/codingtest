N = int(input())
A = [0] + list(map(int, input().split()))

if N == 1:
  print(1)
  exit()

# i번째 인덱스를 선택했을 때, 가장 긴 수열의 길이
dp = [0] * (N + 1)
result = dp[1] = 1

for i in range(2, N + 1):
  # 자기 자신은 선택했다고 가정
  tmp = 1
  for j in range(i - 1, 0, -1):
    if A[j] < A[i] and dp[j] + 1 > tmp:
      tmp = dp[j] + 1
  dp[i] = tmp
  if dp[i] > result:
    result = dp[i]
    
print(result)