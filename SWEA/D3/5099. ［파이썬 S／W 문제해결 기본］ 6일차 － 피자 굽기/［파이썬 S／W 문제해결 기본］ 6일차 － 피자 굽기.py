T=int(input())
for tc in range(1,T+1):
  N,M=map(int,input().split())
  pizza=list(map(int,input().split()))
  pot=[]
  for i in range(N):
    pot.append([i+1, pizza[i]])
  cur=N+1
  i=0
  cnt=0
  while True:
    idx,cheese=pot[i]
    # 빈 피자받침인 경우 continue
    if idx==-1:
      i=(i+1)%N
      continue
    if cheese//2==0:
      cnt+=1
      # 모든 피자를 다 구운 경우, 마지막에 남아있는 피자 번호를 출력
      if cnt==M:
        print(f'#{tc} {idx}')
        break
      pot[i]=[-1,0]
      if cur<=M:
        pot[i]=[cur,pizza[cur-1]]
        cur+=1
    else:
      pot[i]=[idx,cheese//2]
    i=(i+1)%N
