def recursion(n, m):
  if m == 0:
    return 1
  else:
    return n * recursion(n, m - 1)
for _ in range(10):
  t=int(input())
  N,M=map(int,input().split())
  print(f'#{t} {recursion(N, M)}')