n=int(input())
dp=[0]*2_000_000
dp[0]=0
dp[1]=1

if n>0:
  for i in range(2, n+1):
    dp[i]=(dp[i-1]+dp[i-2])%1_000_000_000
elif n<0:
  for i in range(-1, n-1, -1):
    if dp[i+2]-dp[i+1]<0:
      dp[i]=-(abs(dp[i+2]-dp[i+1])%1_000_000_000)
    else:
      dp[i]=(dp[i+2]-dp[i+1])%1_000_000_000

if dp[n]==0:
  print(0)
elif dp[n]>0:
  print(1)
else:
  print(-1)
print(abs(dp[n]))