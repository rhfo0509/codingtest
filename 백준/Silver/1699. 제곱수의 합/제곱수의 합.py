N=int(input())
dp=[0]*100_001
dp[1]=1
for i in range(2,N+1):
  min_value=1+dp[i-1]
  x=2
  while x**2<=i:
    min_value=min(min_value, 1+dp[i-(x**2)])
    x+=1
  dp[i]=min_value
print(dp[N])