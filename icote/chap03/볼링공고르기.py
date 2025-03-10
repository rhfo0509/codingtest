n, m = map(int, input().split())
a = list(map(int, input().split()))

l = []

for i in range(len(a)-1):
  for j in range(i+1, len(a)):
    if a[i] != a[j]:
      l.append((i+1, j+1))

print(len(l))

