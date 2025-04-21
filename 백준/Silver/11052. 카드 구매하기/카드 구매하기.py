N=int(input())
P=[0]+list(map(int,input().split()))

# i개 카드를 구매할 때 얻을 수 있는 최대 금액
dp=[0]*(N+1)

for i in range(1,N+1):
  for j in range(1,i+1):
    # i==4
    # dp[3]+P[1], dp[2]+P[2], dp[1]+P[3], dp[0]+P[4]
    dp[i]=max(dp[i],dp[i-j]+P[j])

print(dp[N])