N = int(input())
A = [0] + list(map(int, input().split()))

if N == 1:
  print(1)
  print(A[1])
  exit()

# i번째 인덱스를 선택했을 때, 가장 긴 수열의 길이
dp = [0] * (N + 1)
max_len = dp[1] = 1
seq = [[] for _ in range(N + 1)]
max_seq = seq[1] = [A[1]]

for i in range(2, N + 1):
  # 자기 자신은 선택했다고 가정
  length = 1
  temp = []
  for j in range(0, i):
    if A[j] < A[i] and dp[j] + 1 > length:
      length = dp[j] + 1
      temp = seq[j]
      
  dp[i] = length
  seq[i] = temp + [A[i]]
  if dp[i] > max_len:
    max_len = dp[i]
    max_seq = seq[i]

print(max_len)
print(*max_seq)