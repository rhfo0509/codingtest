N, M, K = map(int, input().split())
grid = [[0] * M for _ in range(N)]
for _ in range(K):
  R, C = map(int, input().split())
  paper = [list(map(int, input().split())) for _ in range(R)]

  # p1 = [[0] * R for _ in range(C)] 
  # p2 = [[0] * C for _ in range(R)] 
  # p3 = [[0] * R for _ in range(C)] 

  pos=[[] for _ in range(4)]
  for i in range(R):
    for j in range(C):
      if paper[i][j] == 1:
        # 원본
        pos[0].append((i, j))

  for x, y in pos[0]:
    # 90' 회전
    pos[1].append((y, R - 1 - x))

  # for x, y in pos[1]:
  #   p1[x][y]=1
  # for i in range(C):
  #   for j in range(R):
  #     print(p1[i][j], end=' ')
  #   print()
  # print()

  for x, y in pos[1]:
    # 180' 회전
    pos[2].append((y, C - 1 - x))

  # for x, y in pos[2]:
  #   p2[x][y]=1
  # for i in range(R):
  #   for j in range(C):
  #     print(p2[i][j], end=' ')
  #   print()
  # print()

  for x, y in pos[2]:
    # 270' 회전
    pos[3].append((y, R - 1 - x))

  # for x, y in pos[3]:
  #   p3[x][y]=1
  # for i in range(C):
  #   for j in range(R):
  #     print(p3[i][j], end=' ')
  #   print()
  # print()

  for p in pos:
    flag = True
    for i in range(N):
      for j in range(M):
        flag = True

        for x, y in p:
          if i + x < 0 or i + x >= N or j + y < 0 or j + y >= M or grid[i + x][j + y] != 0:
            flag = False
            break

        if flag:
          for x, y in p:
            grid[i + x][j + y] = 1
          break
      
      if flag: break

    if flag: break

result = 0
for i in range(N):
  for j in range(M):
    if grid[i][j] == 1:
      result += 1
print(result)