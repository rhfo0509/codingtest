T=int(input())

# C(M, N) = C(M-1, N-1) + C(M-1,N)
dp=[[0]*(i+1) for i in range(30+1)]

# 초깃값 설정
for i in range(1,30+1):
  dp[i][1]=i
  dp[i][i]=1

for i in range(3,30+1):
  for j in range(2,i):
    dp[i][j]=dp[i-1][j-1]+dp[i-1][j]

for _ in range(T):
  N,M=map(int,input().split())
  print(dp[M][N])