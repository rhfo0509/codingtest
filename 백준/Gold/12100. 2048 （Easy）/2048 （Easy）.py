from copy import deepcopy
N = int(input())

board = [list(map(int, input().split())) for _ in range(N)]

# (보드 정보, 방향)
def move(data, d):
  # 합쳐진 블록인지 여부
  combined = [[False] * N for _ in range(N)]

  # U, D -> transpose
  if d == 0 or d == 1:
    data = list(map(list, zip(*data)))

  for i in range(N):
    # U, L -> 정방향 순회
    if d == 0 or d == 2:
      for j in range(1, N):
        # 블록이 아니라면 continue
        if not data[i][j]:
          continue

        cur = data[i][j]
        k = j
        data[i][j] = 0
        while True:
          # 1. 블록을 발견하지 못했다면
          # 2. 만약 현재 위치의 직전 블록이 결합된 블록이라면
          # 3. 만약 현재 위치의 직전 블록과 같은 숫자가 아닌 블록을 발견했다면
          if k == 0 or combined[i][k - 1] or (data[i][k - 1] and data[i][k - 1] != cur):
            data[i][k] = cur
            break

          # 만약 현재 위치의 직전 블록과 같은 숫자인 블록을 발견했다면
          if data[i][k - 1] == cur:
            data[i][k - 1] *= 2
            combined[i][k - 1] = True
            break

          k -= 1

    # D, R -> 역방향 순회
    else:
      for j in range(N - 2, -1, -1):
        # 블록이 아니라면 continue
        if not data[i][j]:
          continue

        cur = data[i][j]
        k = j
        data[i][j] = 0
        while True:
          # 1. 블록을 발견하지 못했다면
          # 2. 만약 현재 위치의 직후 블록이 결합된 블록이라면
          # 3. 만약 현재 위치의 직후 블록과 같은 숫자가 아닌 블록을 발견했다면 
          if k == N - 1 or combined[i][k + 1] or (data[i][k + 1] and data[i][k + 1] != cur):
            data[i][k] = cur
            break

          # 만약 현재 위치의 직후 블록과 같은 숫자인 블록을 발견했다면
          if data[i][k + 1] == cur:
            data[i][k + 1] *= 2
            combined[i][k + 1] = True
            break

          k += 1

  if d == 0 or d == 1:
    data = list(map(list, zip(*data)))
  # 변경된 보드 정보 return
  return data

# (지금까지 이동한 횟수, 보드 정보, 방향)
def dfs(depth, data, d):
  
  if depth == 5:
    global result
    
    mx = 2
    for i in range(N):
      for j in range(N):
        mx = max(mx, data[i][j])

    result = max(result, mx)
    return
  
  # 보드 정보 복사
  c_data = deepcopy(data)

  # 블록 이동
  c_data = move(c_data, d)
  
  for i in range(4):
    dfs(depth + 1, c_data, i)

result = 2
for i in range(4):
  dfs(0, board, i)
print(result)