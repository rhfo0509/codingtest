r, c, k = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(3)]

# 0-based index
r, c = r - 1, c - 1
time = 0

def operate(A, row, col):
  mx = 0
  for i in range(row):
    # (수, 등장 횟수)
    D = dict()

    for j in range(col):
      # 수를 정렬할 때 0은 무시해야 한다.
      if A[i][j] != 0:
        D[A[i][j]] = D.get(A[i][j], 0) + 1

    # 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬
    tmp = sorted(list(D.items()), key=lambda x: (x[1], x[0]))

    A[i] = []
    for num, count in tmp:
      A[i].append(num)
      A[i].append(count)

    # 가장 큰 행을 기준으로 모든 행의 크기가 변함
    mx = max(mx, len(A[i]))

  # 행 또는 열의 크기가 커진 곳에는 0이 채워진다.
  for i in range(row):
    for _ in range(mx - len(A[i])):
      A[i].append(0)

while time <= 100:

  if r < len(A) and c < len(A[0]) and A[r][c] == k:
    break
  
  row, col = len(A), len(A[0])
  
  if row >= col:
    operate(A, row, col)
  else:
    # 리스트를 A[c][r] 형태로 변경
    col_A = []
    for i in range(col):
      col_A.append([A[j][i] for j in range(row)])
    operate(col_A, col, row)

    # 다시 A[r][c] 형태로 변경
    A = []
    for i in range(len(col_A[0])):
      A.append([col_A[j][i] for j in range(len(col_A))])
  
  time += 1

print(time) if time <= 100 else print(-1)