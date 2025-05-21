T=int(input())

def dfs(start,total):
  global result
  if total==K:
    result+=1
    return
  if total>K:
    return
  for i in range(start,N):
    if not visited[i]:
      visited[i]=True
      dfs(i+1,total+A[i])
      visited[i]=False
for tc in range(1,T+1):
  N,K=map(int,input().split())
  A=list(map(int,input().split()))
  visited=[False]*N
  result=0
  dfs(0,0)
  print(f'#{tc} {result}')
