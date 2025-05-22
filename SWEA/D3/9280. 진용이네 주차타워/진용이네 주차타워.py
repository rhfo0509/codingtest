from collections import deque
T=int(input())
for tc in range(1,T+1):
  n,m=map(int,input().split())
  # 1-based
  R=[0]
  for _ in range(n):
    R.append(int(input()))
  # 1-based
  W=[0]
  for _ in range(m):
    W.append(int(input()))
  used=[0]*(n+1)
  waiting=deque([])
  # 수입
  result=0
  for _ in range(m*2):
    cmd=int(input())
    # 1. 차량이 들어오는 경우
    if cmd>0:
      # 주차 가능 여부
      flag=False
      for i in range(1,n+1):
        if not used[i]:
          flag=True
          used[i]=cmd
          break
      if not flag:
        waiting.append(cmd)
    # 2. 차량이 나가는 경우
    else:
      # 주차된 위치 찾기
      idx=used.index(-cmd)
      used[idx]=0
      # 만약 기다리는 차가 있다면
      if waiting:
        used[idx]=waiting.popleft()
      # 요금 계산
      result+=W[-cmd]*R[idx]
  print(f'#{tc} {result}')
