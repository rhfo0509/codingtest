T=int(input())
for tc in range(1,T+1):
  N,L=map(int,input().split())
  # data=[tuple(map(int,input().split())) for _ in range(N)]
  dp=[[0]*(L+1) for _ in range(N+1)]

  for i in range(1,N+1):
    score,calorie=map(int,input().split())
    for j in range(1,L+1):
      # 재료를 선택하지 않은 경우
      dp[i][j]=dp[i-1][j]
      # 재료를 선택한 경우
      if j-calorie>=0:
        dp[i][j]=max(dp[i][j],dp[i-1][j-calorie]+score)

  # 모든 재료를 고를 수 있고, 칼로리 제한이 L일 때 가치합의 최댓값
  print(f'#{tc} {dp[N][L]}')
