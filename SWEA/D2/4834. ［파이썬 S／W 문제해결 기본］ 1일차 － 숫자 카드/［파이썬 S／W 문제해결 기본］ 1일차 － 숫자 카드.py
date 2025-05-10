T=int(input())
for tc in range(1,T+1):
  result=0
  N=int(input())
  D=dict()
  for i in input():
    D[i]=D.get(i,0)+1
  li=list(D.items())
  li.sort(key=lambda x:(-x[1],-int(x[0])))

  print(f'#{tc} {li[0][0]} {li[0][1]}')
