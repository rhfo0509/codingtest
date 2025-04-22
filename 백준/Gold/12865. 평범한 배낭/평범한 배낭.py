# 0-1 Knapsack Problem
N, K = map(int, input().split())

# dp[i][j] : i 번째 물건까지 선택할 수 있고, 배낭의 용량이 j 일때 가치합의 최댓값
dp = [[0] * (K + 1) for _ in range(N + 1)]

for i in range(1, N + 1):

  W, V = map(int, input().split())

  for j in range(1, K + 1):
    # dp[i - 1][j] : i 번째 물건을 선택하지 않는 경우
    # dp[i - 1][j - W] + V : i 번째 물건을 선택하는 경우 (단, j - W가 0 이상이어야 함)

    dp[i][j] = dp[i - 1][j]

    if j - W >= 0:
      dp[i][j] = max(dp[i][j], dp[i - 1][j - W] + V)

    # A 6 13
    # B 4 8
    # C 3 6
    # D 5 12

    # A 만 선택 가능      ->  [0, 0, 0, 0, 0, 13, 13]
    # A, B 선택 가능      ->  [0, 0, 0, 8, 8, 13, 13]
    # A, B, C 선택 가능   ->  [0, 0, 6, 8, 8, 13, 14]
    # A, B, C, D 선택 가능->  [0, 0, 6, 8, 12, 13, 14]

# 구하고자 하는 값은 모든 물건을 선택할 수 있고, 배낭의 용량이 K 일때 가치합의 최댓값
print(dp[N][K])