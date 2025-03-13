n, l, k = map(int, input().split())

a = []
for _ in range(n):
  a.append(tuple(map(int, input().split())))

score = 0

a.sort(key=lambda x: x[1])

idx = 0
for i in a:
  if i[1] <= l:
    idx += 1
    score += 140
    k -= 1
    if k == 0:
      break
  else:
    break

if k > 0:
  a = a[idx:]
  a.sort(key=lambda x: -x[0])

  for j in a:
    if j[0] <= l:
      score += 100
      k -= 1
      if k == 0:
        break

print(score)