n, m = map(int, input().split())

cutoff = []
for i in range(n):
  p, l = map(int, input().split())
  miles = list(map(int, input().split()))
  miles.sort(reverse=True)

  if p < l:
    cutoff.append(1)
  else:
    cutoff.append(miles[l - 1])

cutoff.sort()
result = 0

for mile in cutoff:
    if m < mile:
      break
    m -= mile
    result += 1

print(result)