X=int(input())
dp=[0]*(X+1)
for i in range(2,X+1):
  # 3. 1을 뺀다.
  dp[i]=dp[i-1]+1
  # 2. X가 2로 나누어 떨어지면, 2로 나눈다.
  if i%2==0:
    dp[i]=min(dp[i],dp[i//2]+1)
  # 3. X가 3으로 나누어 떨어지면, 3으로 나눈다.
  if i%3==0:
    dp[i]=min(dp[i],dp[i//3]+1)
print(dp[X])