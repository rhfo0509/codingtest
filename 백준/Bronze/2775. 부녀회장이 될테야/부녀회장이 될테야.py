T=int(input())
for _ in range(T):
  # k층 n호
  k=int(input())
  n=int(input())
  dp=[[0]*(n+1) for _ in range(k+1)]
  # 초깃값 설정
  dp[0]=[i for i in range(0, n+1)]
  for i in range(1,k+1):
    for j in range(1,n+1):
      dp[i][j]=sum(dp[i-1][:j+1])
  print(dp[i][j])