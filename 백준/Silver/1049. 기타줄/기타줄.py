N, M = map(int, input().split())

mp = 1000 # 최소 패키지 가격
me = 1000 # 최소 낱개 가격
for _ in range(M):
  p, e = map(int, input().split())
  if p < mp:
    mp = p
  if e < me:
    me = e

if me * 6 < mp:
  print(me * N)
else:
  print((N // 6) * mp + min((N % 6) * me, mp))