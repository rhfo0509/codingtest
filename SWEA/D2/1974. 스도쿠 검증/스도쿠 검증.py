T = int(input())

def make_square(x, y):
  square = []
  for i in range(x, x + 3):
    for j in range(y, y + 3):
      square.append(data[i][j])

  return square

def vaild(data):
  return len(set(data)) == 9

for tc in range(1, T + 1):
  data = [list(map(int, input().split())) for _ in range(9)]
  result = 1

  for i in range(9):
    # 가로(ㅡ) 검증
    row = data[i]
    if not vaild(row): 
      result = 0
      break

    # 세로(ㅣ) 검증
    col = [data[j][i] for j in range(9)]
    if not vaild(col):
      result = 0
      break

  if result == 1:
    for i in range(0, 9, 3):
      for j in range(0, 9, 3):
        # 네모(ㅁ) 검증
        square = make_square(i, j)
        if not vaild(square):
          result = 0
          break
      if result == 0:
        break

  print(f'#{tc} {result}')
