from itertools import combinations
N = int(input())
data = [list(map(int, input().split())) for _ in range(N)]

res = int(1e9)
li = list(combinations(range(N), N // 2))
for start in li[:len(li) // 2]:
  link = tuple(i for i in range(N) if i not in start)
  
  s_sum = 0
  for s_comb in combinations(start, 2):
    sx, sy = s_comb
    s_sum += data[sx][sy] + data[sy][sx]

  l_sum = 0
  for l_comb in combinations(link, 2):
    lx, ly = l_comb
    l_sum += data[lx][ly] + data[ly][lx]

  res = min(res, abs(s_sum - l_sum))
print(res)