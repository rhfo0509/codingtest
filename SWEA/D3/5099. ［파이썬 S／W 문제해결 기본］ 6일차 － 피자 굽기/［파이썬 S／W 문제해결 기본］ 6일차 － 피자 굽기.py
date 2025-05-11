from collections import deque
T=int(input())
for tc in range(1,T+1):
  N,M=map(int,input().split())
  pizza=deque(map(int,input().split()))
  pot=deque([])
  for i in range(1,N+1):
    pot.append((i,pizza.popleft()))
  cur=N+1
  while len(pot)>1:
    idx,cheese=pot.popleft()
    # 이번에 치즈의 양이 0이 됨을 의미한다.
    if cheese==1:
      if len(pizza)>=1:
        pot.append((cur,pizza.popleft()))
        cur+=1
    else:
      pot.append((idx,cheese//2))
  print(f'#{tc} {pot[0][0]}')
