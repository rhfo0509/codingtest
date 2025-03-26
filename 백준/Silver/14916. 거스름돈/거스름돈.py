n = int(input())
INF = 100_001

if n == 1 or n == 3:
  print(-1)
  exit()

d = [INF] * INF

d[2] = 1
d[4] = 2
d[5] = 1

for i in range(6, n + 1):
  d[i] = min(d[i - 2], d[i - 5]) + 1

print(d[n])