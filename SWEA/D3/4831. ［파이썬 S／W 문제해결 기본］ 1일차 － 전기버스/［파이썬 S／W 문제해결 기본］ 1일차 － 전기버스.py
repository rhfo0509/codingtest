T=int(input())
for tc in range(1,T+1):
  result=0
  K,N,M=map(int,input().split())
  stations=list(map(int,input().split()))
  i=0
  j=0
  cur=-1
  while True:
    if cur+K>=N:
      break
    prev=cur
    # 가장 멀리 있으면서 한 번 충전으로 도착할 수 있는 정류장을 찾는다.
    while j<M and stations[j]<=i+K:
      cur=stations[j]
      j+=1
    # 충전기 설치가 잘못된 경우
    if prev==cur:
      result=0
      break
    result+=1
    i=cur
  print(f'#{tc} {result}')
