N = int(input())
a = []
for _ in range(N):
  a.append(input())

res = ''
for i in range(len(a[0])):
  s = set()
  for j in range(N):
    s.add(a[j][i])
  if len(s) != 1:
    res += '?'
  else:
    res += a[0][i]
print(res)