T=int(input())
dp=[0]*31
dp[1]=1
dp[2]=3
for i in range(3,31):
  dp[i]=dp[i-1]+2*dp[i-2]
for tc in range(1,T+1):
  N=int(input())
  print(f'#{tc} {dp[N//10]}')
