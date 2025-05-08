for _ in range(10):
  N=int(input())
  data=[list(map(int,input().split())) for _ in range(100)]
  for i in range(100):
    if data[0][i] == 1:
      # 출발
      x, y = 0, i
      # L, D, R 순서
      dx = [0, 1, 0]
      dy = [-1, 0, 1]
      # 처음: 아래(D)
      d = 1
      while True:
        if x == 99:
          break
        if d == 1 and y > 0 and data[x][y - 1] == 1:
          d = 0
        elif d == 1 and y < 99 and data[x][y + 1] == 1:
          d = 2
        elif (d == 0 or d == 2) and data[x + 1][y] == 1:
          d = 1

        x += dx[d]
        y += dy[d]

      if data[x][y] == 2:
        print(f'#{N} {i}')
        break