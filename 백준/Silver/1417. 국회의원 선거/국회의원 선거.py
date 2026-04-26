n = int(input())
d = int(input())
a = []

for _ in range(n-1):
  a.append(int(input()))

cnt = 0
while a:
  m = max(a)

  if d > m:
    break
  a[a.index(m)] -= 1
  d += 1
  cnt += 1


print(cnt)