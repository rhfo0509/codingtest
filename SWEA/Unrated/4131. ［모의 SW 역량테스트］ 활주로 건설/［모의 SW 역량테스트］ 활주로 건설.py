T = int(input())

def check(data, used):
  global X
  
  for i in range(1, N):
    length = 0

    if data[i - 1] < data[i]:
      for j in range(i - 1, -1, -1):
        if data[j] == data[i] - 1 and not used[j]:
          length += 1
        else:
          break

        if length == X:
          break
      
      if length == X:
        for k in range(i - 1, i - 1 - X, -1):
          used[k] = True
      else:
        return 0

    elif data[i - 1] > data[i]:
      for j in range(i, N):
        if data[j] == data[i - 1] - 1 and not used[j]:
          length += 1
        else:
          break

        if length == X:
          break

      if length == X:
        for k in range(i, i + X):
          used[k] = True
      else:
        return 0
      
  return 1
    
for tc in range(1, T + 1):
  N, X = map(int, input().split())

  data = [list(map(int, input().split())) for _ in range(N)]
  row_used = [[False] * N for _ in range(N)]
  col_used = [[False] * N for _ in range(N)]

  result = 0

  for i in range(N):
    row = data[i]
    col = [data[j][i] for j in range(N)]

    result += check(row, row_used[i])
    result += check(col, col_used[i])

  print(f'#{tc} {result}')