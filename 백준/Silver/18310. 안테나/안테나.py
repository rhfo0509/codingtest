n = int(input())
h = list(map(int, input().split()))

h.sort()

if len(h) % 2 == 1:
  print(h[len(h) // 2])
else:
  l = h[len(h) // 2 - 1]
  r = h[len(h) // 2]

  l_sum = 0
  r_sum = 0
  for i in h:
    l_sum += abs(l - i)
    r_sum += abs(r - i)
  print(l) if l_sum <= r_sum else print(r)