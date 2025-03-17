N = int(input())

a = []
for _ in range(N):
  a.append(tuple(map(int, input().split())))

a.sort()

cnt = 1
m = a[0][1]

for i in range(1, N):
  if m <= a[i][0]:
    cnt += 1
    m = a[i][1]
  if a[i][1] < m:
    m = a[i][1]

print(cnt)
  