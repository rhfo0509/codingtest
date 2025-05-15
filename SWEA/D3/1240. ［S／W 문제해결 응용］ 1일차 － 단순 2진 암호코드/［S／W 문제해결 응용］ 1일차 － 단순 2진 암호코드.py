T = int(input())

for tc in range(1, T + 1):
  N, M = map(int, input().split())
  data = [input() for _ in range(N)]

  codes = {
    '0001101': 0,
    '0011001': 1,
    '0010011': 2,
    '0111101': 3,
    '0100011': 4,
    '0110001': 5,
    '0101111': 6,
    '0111011': 7,
    '0110111': 8,
    '0001011': 9,
  }

  result = 0
  cypher = 0

  flag = False
  for i in range(N):
    for j in range(M - 1, 5, -1):
      if data[i][j] == '1':
        flag = True

        left, right = j - 6, j + 1
        for k in range(8):

          code = data[i][left - 7 * k : right - 7 * k]
          num = codes.get(code)

          if k % 2:
            cypher += num * 3
          else:
            cypher += num

          result += num
      if flag:
        break
    if flag:
      break

  print(f'#{tc}', end=' ')
  print(0) if cypher % 10 else print(result)