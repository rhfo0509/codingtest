T=int(input())
for tc in range(1,T+1):
  N,K=map(int,input().split())
  data=sorted(list(map(int,input().split())),reverse=True)
  result=0
  for i in range(K):
    result+=data[i]
  print(f'#{tc} {result}')
