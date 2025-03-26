A, B = map(int, input().split())

cnt = 0
while A < B:
  t = str(B)[-1]
  if t in '3579':
    break
  if B % 2 == 0:
    B //= 2
  elif int(t) == 1:
    B = int(str(B)[:-1])
  cnt += 1

if A != B:
  print(-1)
else:
  print(cnt + 1)