cnt = 0
def n_queen(i):
  global cnt
  if i == N:
    cnt += 1
    return
  # 이미 사용된 "칸"인지 체크
  for j in range(N):
    isused = False
    for pos in result:
      qx, qy = pos
      # 같은 "열"에 있는지 체크
      if qy == j:
        isused = True
        break
      # 같은 "대각선(╱)"에 있는지 체크
      elif qx + qy == i + j:
        isused = True
        break
      # 같은 "대각선(╲)"에 있는지 체크
      elif qx - qy == i - j:
        isused = True
        break
    if not isused:
      result.append((i, j))
      n_queen(i + 1)
      result.pop()
    
N = int(input())
result = []
n_queen(0)
print(cnt)