n = int(input())

cnt = 0
cnt5 = 0

if n >= 5:
  cnt = cnt5 = n // 5
  n = n - (cnt * 5)

if n >= 3:
  n = n - 3
  cnt += 1

# 나머지가 1인 경우 : 5kg가 1개 이상 존재
# 나머지가 2인 경우 : 5kg가 2개 이상 존재
if n == 0:
  pass
elif cnt5 >= 1 and n == 1:
  cnt += 1
elif cnt5 >= 2 and n == 2:
  cnt += 2
else:
  cnt = -1

print(cnt)