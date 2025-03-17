import sys
input = sys.stdin.readline

T = int(input())
res = []

for _ in range(T):
  N = int(input())

  a = []

  for i in range(N):
    a.append(tuple(map(int, input().split())))

  a.sort()
  cnt = 1 # 첫 번째는 무조건 합격

  mv = a[0][1]
  for i in range(1, N):
    if a[i][1] < mv:
      mv = a[i][1]
      cnt += 1

  res.append(cnt)

for i in res:
  print(i)