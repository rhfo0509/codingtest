import math

# 2부터 1,000까지의 소수 판별
n = 1000
# 처음엔 모든 수가 소수(True)인 것으로 초기화
array = [True for _ in range(n + 1)]

for i in range(2, int(math.sqrt(n)) + 1):
  if array[i] == True:
    j = 2
    while i * j <= n:
      array[i * j] = False
      j += 1

for i in range(2, n + 1):
  if array[i]:
    print(i, end=' ')