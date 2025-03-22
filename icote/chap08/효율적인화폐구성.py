# 입력 받기
n, m = map(int, input().split())
coins = [int(input()) for _ in range(n)]

# DP 테이블 초기화
dp = [10001] * (m + 1)
dp[0] = 0  # 0원을 만들기 위해 필요한 동전 개수는 0개

# 다이나믹 프로그래밍 진행
for coin in coins:
    for i in range(coin, m + 1):
        if dp[i - coin] != 10001:  # 만들 수 있는 경우만 갱신
            dp[i] = min(dp[i], dp[i - coin] + 1)

# 결과 출력
print(dp[m] if dp[m] != 10001 else -1)