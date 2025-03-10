# 곱하기보다 더하기가 더 높은 예시?
# 1. 0과 n의 연산일 때
# 2. 1과 n의 연산일 때
# 나머지는 다 곱하기가 더 크다...

a = input()
sum = int(a[0])

for i in range(1, len(a)):
  n = int(a[i])
  if sum in {0, 1} or n in {0, 1}:
    sum = sum + n
  else:
    sum = sum * n

print(sum)