N = int(input())
data = list(map(int, input().split()))

pos = [0] * N
for i in range(N):
  cnt = 0
  d = 0
  while True:
    if pos[d] != 0:
      d += 1
      continue
    elif data[i] == cnt:
      break
    else:
      d += 1
      cnt += 1
  pos[d] = i + 1
  
print(*pos)