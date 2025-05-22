T=int(input())

def dfs(depth,rate):
  global result
  if rate<=result:
    return
  if depth==N:
    result=rate
  for i in range(N):
    if not used[i]:
      used[i]=True
      dfs(depth+1,rate*data[depth][i]/100)
      used[i]=False
for tc in range(1,T+1):
  N=int(input())
  data=[list(map(int,input().split())) for _ in range(N)]
  used=[False]*N
  result=0
  dfs(0,1)
  print(f'#{tc} {(result*100):.6f}')