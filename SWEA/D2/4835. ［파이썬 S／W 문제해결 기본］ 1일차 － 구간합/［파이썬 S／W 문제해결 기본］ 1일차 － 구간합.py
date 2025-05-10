T=int(input())
for tc in range(1,T+1):
  N,M=map(int,input().split())
  li=list(map(int,input().split()))
  mn=mx=cur=sum(li[0:M])
  for i in range(M,N):
    cur-=li[i-M]
    cur+=li[i]
    mn=min(mn,cur)
    mx=max(mx,cur)
  print(f'#{tc} {mx-mn}')
