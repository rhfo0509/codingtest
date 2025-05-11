T=int(input())
for tc in range(1,T+1):
  N=int(input())
  li=list(map(int,input().split()))
  asc=sorted(li)
  desc=sorted(li,reverse=True)
  print(f'#{tc}',end=' ')
  for i in range(5):
    print(desc[i],end=' ')
    print(asc[i],end=' ')
  print()
