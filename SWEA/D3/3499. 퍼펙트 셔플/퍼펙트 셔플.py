T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  data = list(input().split())

  result = []
  if N == 1:
    result.append(data[0])
  elif N % 2 == 0:
    left = data[:N // 2]
    right = data[N // 2:]
  else:
    left = data[:N // 2]
    right = data[N // 2 + 1:]

  for i in range(N // 2):
    result.append(left[i])
    result.append(right[i])

  if N % 2 == 1:
    result.append(data[N // 2])

  print(f'#{tc}', *result)

