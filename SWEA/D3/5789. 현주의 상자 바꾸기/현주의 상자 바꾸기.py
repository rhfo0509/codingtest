T=int(input())
for tc in range(1,T+1):
  N,Q=map(int,input().split())
  result=[0]*(N+1)
  queries=[tuple(map(int,input().split())) for _ in range(Q)][::-1]
  for i in range(Q):
    L,R=queries[i]
    for j in range(L,R+1):
      if result[j]==0:
        result[j]=Q-i
  print(f'#{tc}',*result[1:])