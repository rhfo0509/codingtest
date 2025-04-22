# Longest Common Subsequence (LCS)

A = [0] + list(input())
B = [0] + list(input())

# dp[i][j] : A에서 i 번째까지, B에서 j 번째까지 선택할 수 있을 때 만들 수 있는 최장 공통 부분 수열의 길이
dp = [[0] * len(B) for _ in range(len(A))]

# A : ACAYKP
# B : CAPCAK

for j in range(1, len(B)):
  for i in range(1, len(A)):
    if A[i] == B[j]:
      dp[i][j] = dp[i - 1][j - 1] + 1
    # 비교하는 두 글자가 서로 같다면
    # A와 B 문자열의 바로 직전 상태 + 현재 글자 와 같음
    else:
    # 만약 비교하는 두 글자가 서로 다르다면
    # 글자 중 하나는 버려야 됨 -> 어느 글자를 버려야 할지 선택

    # ex) 문자열 A에서 ACAY, 문자열 B에 CA를 비교
    # Y와 A는 서로 다름 -> Y를 버리는 게 LCS가 더 크다.
    # 즉, 왼쪽 값과 위쪽 값 중 더 큰 값을 현재 위치에 반영
      dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

print(dp[-1][-1])