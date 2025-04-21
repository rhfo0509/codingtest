N=int(input())
dp=[0]*(N+1)
dp[1]=1
if N>=2: dp[2]=2
if N>=3: dp[3]=1
for i in range(4,N+1):
  dp[i]=(i//3)+dp[i%3]
print('SK') if dp[N]%2==1 else print('CY')