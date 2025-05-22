T=int(input())
for tc in range(1,T+1):
  N=int(input())
  data=list(map(int,input().split()))
  dp=[1]*N
  for i in range(1,N):
    mx=dp[i]
    for j in range(i-1,-1,-1):
      if data[j]<data[i]:
        mx=max(mx,dp[j]+1)
    dp[i]=mx
  print(f'#{tc} {max(dp)}')
