n = int(input())

cent = [25, 10, 5, 1]

c = []

for _ in range(n):
  c.append(int(input()))

for i in range(n):
    for j in range(4):
      print(c[i] // cent[j], end=' ')
      c[i] %= cent[j]
    print()