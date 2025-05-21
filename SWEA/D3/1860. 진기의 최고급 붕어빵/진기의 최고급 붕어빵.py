from collections import deque
T=int(input())
for tc in range(1,T+1):
  N,M,K=map(int,input().split())
  data=deque(sorted(map(int,input().split())))
  time=0
  count=0
  flag=True
  while True:
    if time and time%M==0:
      count+=K
    while data and data[0]==time:
      data.popleft()
      count-=1
      if count<0:
        flag=False
        break
    if not flag or not data:
      break
    time+=1
  print(f'#{tc}',end=' ')
  print('Possible' if flag else 'Impossible')

