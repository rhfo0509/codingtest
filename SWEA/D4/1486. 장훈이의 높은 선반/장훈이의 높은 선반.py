T=int(input())

def dfs(start,height):
  global result
  if height>=B:
    result=min(result,height-B)
    return
  if height-B>=result:
    return
  for i in range(start,N):
    if not visited[i]:
      visited[i]=True
      dfs(i+1,height+data[i])
      visited[i]=False
for tc in range(1,T+1):
  N,B=map(int,input().split())
  data=list(map(int,input().split()))
  visited=[False]*N
  result=int(1e9)
  dfs(0,0)
  print(f'#{tc} {result}')