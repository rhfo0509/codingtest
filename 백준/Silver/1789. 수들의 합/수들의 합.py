S = int(input())
N = 1

cnt = 0
tmp = 1
while tmp <= S:
  cnt += 1
  N += 1
  tmp += N
print(cnt)