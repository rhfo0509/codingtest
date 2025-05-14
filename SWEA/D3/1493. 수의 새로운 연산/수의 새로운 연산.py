T = int(input())

data = [(0, 0)]
n = 2
while True:
  # (10000, 10000)
  if n == 285:
    break
  for i in range(1, n):
    data.append((i, n - i))
  n += 1

for tc in range(1, T + 1):
  p, q = map(int, input().split())
  px, py = data[p]
  qx, qy = data[q]
  print(f'#{tc} {data.index((px + qx, py + qy))}')
