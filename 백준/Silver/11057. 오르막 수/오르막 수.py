N=int(input())

# 길이가 i이면서 끝자리가 0,...,9인 오르막 수의 개수
dp=[[0]*10 for _ in range(N+1)]

for i in range(10):
  dp[1][i]=1

for i in range(2,N+1):
  s=0
  for j in range(10):
    s+=dp[i-1][j]
    dp[i][j]=s
    
print(sum(dp[N])%10_007)