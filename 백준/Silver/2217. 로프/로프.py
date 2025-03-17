N = int(input())

a = []
for _ in range(N):
  a.append(int(input()))

a.sort(reverse=True)

w = a[0]
for i in range(1, len(a)):
  tmp = (i + 1) * a[i]
  if w < tmp:
    w = tmp

print(w)