T=int(input())
for tc in range(1,T+1):
  N=int(input())
  data=[0]*5_001
  for _ in range(N):
    A,B=map(int,input().split())
    for i in range(A,B+1):
      data[i]+=1
  P=int(input())
  result=[]
  for _ in range(P):
    result.append(data[int(input())])
  print(f'#{tc}',*result)