T = int(input())
for _ in range(T):
  s = input().split()
  res = ''
  for w in s:
    res += w[::-1] + ' '
  print(res)