n = int(input())

a = [300, 60, 10]
cnt = [0] * 3

for i in range(3):
  cnt[i] = n // a[i]
  n %= a[i]

if n == 0:
  print(*cnt)
else:
  print(-1)
