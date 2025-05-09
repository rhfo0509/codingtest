from collections import deque
T=10
for _ in range(T):
  N=int(input())
  data=deque(map(int,input().split()))
  i=1
  while True:
    pn=data.popleft()
    if pn-i<=0:
      data.append(0)
      break
    data.append(pn-i)
    i=(i%5)+1

  print(f'#{N}', end=' ')
  for d in data:
    print(d, end=' ')
  print()