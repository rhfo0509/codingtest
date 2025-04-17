T=int(input())
for _ in range(T):
  n=int(input())
  dp=[0]*(n+1)
  dp[1]=1 # 1
  if n>=2:
    dp[2]=2 # 1+1, 2
  if n>=3:
    dp[3]=4 # 1+1+1, 1+2, 2+1, 3
  for i in range(4,n+1):
    # 1과 dp[i-1]의 조합
    dp[i]+=dp[i-1] # 1+1+1+1, 1+1+2, 1+2+1, 1+3
    # 2와 dp[i-2]의 조합
    dp[i]+=dp[i-2] # 2+1+1, 2+2
    # 3과 dp[i-3]의 조합
    dp[i]+=dp[i-3] # 3+1
  print(dp[n])