N, L = map(int, input().split())

data = [list(map(int, input().split())) for _ in range(N)]
result = 0

# ㅡ 방향 탐색
ramp_row = [[0] * N for _ in range(N)]

# ㅣ 방향 탐색
ramp_col = [[0] * N for _ in range(N)]

def check(data, ramp):
  for j in range(1, N):
    if data[j - 1] < data[j]:
      # 왼쪽 방향으로 순회
      count = 0
      for k in range(j - 1, -1, -1):
        # 경사로가 존재하면 break
        if ramp[k]:
          break
        # 높이 차이가 1이 아니면 break
        # 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우 break
        if data[k] != data[j] - 1:
          break
        
        # 조건 만족 시 count를 1 증가
        count += 1

        # 경사로를 만들 수 있으면 break
        if count == L:
          break

      # 경사로를 만들 수 없으면, 이 길은 건널 수 없다.
      if count != L:
        return False

      # 경사로를 만들 수 있으면
      for k in range(j - 1, j - 1 - L, -1):
        ramp[k] = 1

    elif data[j - 1] > data[j]:
      # 오른쪽 방향으로 순회
      count = 0
      for k in range(j, N):
        # 경사로가 존재하면 break
        if ramp[k]:
          break
        # 높이 차이가 1이 아니면 break
        # 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우 break
        if data[k] != data[j - 1] - 1:
          break
        
        # 조건 만족 시 count를 1 증가
        count += 1

        # 경사로를 만들 수 있으면 break
        if count == L:
          break

      # 경사로를 만들 수 없으면, 이 길은 건널 수 없다.
      if count != L:
        return False

      # 경사로를 만들 수 있으면
      for k in range(j, j + L):
        ramp[k] = 1
    
  return True

for i in range(N):
  row = data[i]
  col = [data[j][i] for j in range(N)]
  if check(row, ramp_row[i]):
    result += 1
  if check(col, ramp_col[i]):
    result += 1

print(result)