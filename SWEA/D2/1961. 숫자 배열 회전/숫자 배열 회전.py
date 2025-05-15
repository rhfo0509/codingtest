T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  data = [list(map(int, input().split())) for _ in range(N)]

  print(f'#{tc}')

  result = [[] * 3 for _ in range(N)]

  for _ in range(3):
    tmp = [[0] * N for _ in range(N)]
    for i in range(N):
      for j in range(N):
        tmp[j][N - 1 - i] = data[i][j]

    for i in range(N):
      result[i].append(''.join(map(str, tmp[i])))

    data = tmp

  for i in range(N):
    print(*result[i])
