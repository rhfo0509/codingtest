import sys
input = sys.stdin.readline

N, L = map(int, input().split())

puddles = []
for _ in range(N):
  puddles.append(tuple(map(int, input().split())))

puddles.sort()

end = puddles[-1][1]

i = 0
result = 0
cur = puddles[i][0]

while cur < end:
  cnt = (puddles[i][1] - cur - 1) // L + 1
  result += cnt

  cur += L * cnt
  i += 1

  if i < N and cur < puddles[i][0]:
    cur = puddles[i][0]

print(result)