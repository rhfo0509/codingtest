T = int(input())

for tc in range(1, T + 1):
  N, M, K = map(int, input().split())
  data = list(map(int, input().split()))

  pos = 0
  for _ in range(K):
    pos += M
    if pos == len(data):
      data.insert(pos, data[pos - 1] + data[0])
    else:
      pos %= len(data)
      data.insert(pos, data[pos - 1] + data[pos])

  result = data[::-1][:10]
  print(f'#{tc}', *result)
