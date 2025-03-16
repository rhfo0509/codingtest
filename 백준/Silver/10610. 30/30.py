N = input()

NA = list(map(int, N))
NA.sort(reverse=True)

if 0 not in NA or sum(NA) % 3 != 0:
  print(-1)
else:
  print(int(''.join(map(str, NA))))