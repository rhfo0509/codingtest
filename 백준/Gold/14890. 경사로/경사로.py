N, L = map(int, input().split())

data = [list(map(int, input().split())) for _ in range(N)]
result = 0

# ㅡ 방향 탐색
ramp_row = [[0] * N for _ in range(N)]

# ㅣ 방향 탐색
ramp_col = [[0] * N for _ in range(N)]

for i in range(N):
  row = data[i]
  # 길을 건널 수 있는지 여부
  flag = True
  
  # 범위 내에서 탐색
  for j in range(1, N):
    if row[j - 1] < row[j]:
      # 왼쪽 방향으로 순회
      count = 0
      for k in range(j - 1, -1, -1):
        # 경사로가 존재하면 break
        if ramp_row[i][k]:
          break
        # 높이 차이가 1이 아니면 break
        # 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우 break
        if row[k] != row[j] - 1:
          break
        
        # 조건 만족 시 count를 1 증가
        count += 1

        # 경사로를 만들 수 있으면 break
        if count == L:
          break

      # 경사로를 만들 수 없으면, 이 길은 건널 수 없다.
      if count != L:
        flag = False
        break

      # 경사로를 만들 수 있으면
      for k in range(j - 1, j - 1 - L, -1):
        ramp_row[i][k] = 1

    elif row[j - 1] > row[j]:
      # 오른쪽 방향으로 순회
      count = 0
      for k in range(j, N):
        # 경사로가 존재하면 break
        if ramp_row[i][k]:
          break
        # 높이 차이가 1이 아니면 break
        # 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우 break
        if row[k] != row[j - 1] - 1:
          break
        
        # 조건 만족 시 count를 1 증가
        count += 1

        # 경사로를 만들 수 있으면 break
        if count == L:
          break

      # 경사로를 만들 수 없으면, 이 길은 건널 수 없다.
      if count != L:
        flag = False
        break

      # 경사로를 만들 수 있으면
      for k in range(j, j + L):
        ramp_row[i][k] = 1

  if flag:
    result += 1

for i in range(N):
  col = [data[j][i] for j in range(N)]
  # 길을 건널 수 있는지 여부
  flag = True
  
  # 범위 내에서 탐색
  for j in range(1, N):
    if col[j - 1] < col[j]:
      # 왼쪽 방향으로 순회
      count = 0
      for k in range(j - 1, -1, -1):
        # 경사로가 존재하면 break
        if ramp_col[i][k]:
          break
        # 높이 차이가 1이 아니면 break
        # 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우 break
        if col[k] != col[j] - 1:
          break
        
        # 조건 만족 시 count를 1 증가
        count += 1

        # 경사로를 만들 수 있으면 break
        if count == L:
          break

      # 경사로를 만들 수 없으면, 이 길은 건널 수 없다.
      if count != L:
        flag = False
        break

      # 경사로를 만들 수 있으면
      for k in range(j - 1, j - 1 - L, -1):
        ramp_col[i][k] = 1

    elif col[j - 1] > col[j]:
      # 오른쪽 방향으로 순회
      count = 0
      for k in range(j, N):
        # 경사로가 존재하면 break
        if ramp_col[i][k]:
          break
        # 높이 차이가 1이 아니면 break
        # 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우 break
        if col[k] != col[j - 1] - 1:
          break
        
        # 조건 만족 시 count를 1 증가
        count += 1

        # 경사로를 만들 수 있으면 break
        if count == L:
          break

      # 경사로를 만들 수 없으면, 이 길은 건널 수 없다.
      if count != L:
        flag = False
        break

      # 경사로를 만들 수 있으면
      for k in range(j, j + L):
        ramp_col[i][k] = 1

  if flag:
    result += 1

print(result)