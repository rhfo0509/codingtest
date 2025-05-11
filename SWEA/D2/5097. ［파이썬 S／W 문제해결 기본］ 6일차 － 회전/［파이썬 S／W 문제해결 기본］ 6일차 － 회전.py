from collections import deque
T=int(input())
for tc in range(1,T+1):
  N,M=map(int,input().split())
  li=deque(map(int,input().split()))
  for _ in range(M):
    li.append(li.popleft())
  print(f'#{tc} {li[0]}')
