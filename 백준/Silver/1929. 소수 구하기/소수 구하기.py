import math
M, N = map(int, input().split())

a = [True] * (N + 1)
a[1] = False

for i in range(2, int(math.sqrt(N)) + 1):
  if a[i] == True:
    j = 2
    while i * j <= N:
      a[i * j] = False
      j += 1

for i in range(M, N + 1):
  if a[i] == True:
    print(i)