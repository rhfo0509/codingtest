n, k = map(int, input().split())

a = []
for _ in range(n):
  a.append(int(input()))

a.sort(reverse=True)

cnt = 0
for i in a:
  if i <= k:
    cnt += k // i
    k %= i

print(cnt)