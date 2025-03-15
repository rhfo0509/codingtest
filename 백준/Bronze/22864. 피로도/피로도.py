A, B, C, M = map(int, input().split())

f = 0
w = 0

for _ in range(24):
  if f <= M - A:
    f += A
    w += B
  else:
    f -= C
    if f < 0: f = 0

print(w)