A=[0]+list(input())
B=[0]+list(input())
dp=[[0]*len(A) for _ in range(len(B))]
lcs=[['']*len(A) for _ in range(len(B))]
for i in range(1,len(B)):
  for j in range(1,len(A)):
    if A[j]==B[i]:
      dp[i][j]=dp[i-1][j-1]+1
      lcs[i][j]=lcs[i-1][j-1]+A[j]
    else:
      dp[i][j]=max(dp[i-1][j],dp[i][j-1])
      if dp[i-1][j]>dp[i][j-1]:
        dp[i][j]=dp[i-1][j]
        lcs[i][j]=lcs[i-1][j]
      else:
        dp[i][j]=dp[i][j-1]
        lcs[i][j]=lcs[i][j-1]
print(dp[-1][-1])
if dp[-1][-1]!=0:
  print(lcs[-1][-1])