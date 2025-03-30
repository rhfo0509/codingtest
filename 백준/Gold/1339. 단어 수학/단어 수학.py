N = int(input())

a = []
for _ in range(N):
  s = input().zfill(8)
  a.append(s)

D1 = dict()
for i in range(7, -1, -1):
  T = dict()
  for j in range(N):
    c = a[j][i]
    if c != '0':
      if c not in D1.keys():
        D1[c] = 0
      D1[c] += 10 ** (8 - i - 1)

M = 9
D2 = dict(sorted(D1.items(), key=lambda x: -x[1]))

for k in D2.keys():
  D2[k] = M
  M -= 1

result = 0
for i in range(N):
  for j in range(8):
    c = a[i][j]
    if c != '0':
      result += 10 ** (8 - j - 1) * D2[c]

print(result)