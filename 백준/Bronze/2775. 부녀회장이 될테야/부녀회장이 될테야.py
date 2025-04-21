T=int(input())
dp=[[0]*15 for _ in range(15)]
# 초깃값 설정
for i in range(15):
  dp[i][1]=1
  dp[0][i]=i
for i in range(1,15):
  for j in range(2,15):
    dp[i][j]=dp[i-1][j]+dp[i][j-1]

for _ in range(T):
  # k층 n호
  k=int(input())
  n=int(input())
  print(dp[k][n])