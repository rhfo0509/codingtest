# # n = 3 -> 13
# # n = 4 -> 13 14 24 -> d[3] + max(14 24)
# # n = 5 -> 13 14 24 15 25 35 + d[4] + max(15 25 35)

# n = int(input())
# a = list(map(int, input().split()))
# a.insert(0, 0)

# d = [0] * 101

# d[3] = a[0] + a[2]
# for i in range(4, n+1):
#   d[i] = max(d[i - 1], max([a[i] for i in range(1, i-1)]) + a[i])

# print(d[n])

# ------------------------------------------------------------------

# 문제 해결 아이디어는 다음과 같다.
# i번째 식량창고에 대해 털지 말지 선택하는 경우의 수는
# 1. i-2번째가 털린 경우: i번째를 털 수 있음
# 2. i-1번째가 털린 경우: i번째를 털 수 없음
# 즉, max(d[i-2] + a[i], d[i-1])가 점화식이 될 수 있다.

n = int(input())
a = list(map(int, input().split()))

d = [0] * 100
d[0] = a[0]
d[1] = max(a[0], a[1])

for i in range(2, n):
  d[i] = max(d[i-2] + a[i], d[i-1])

print(d[n-1])

