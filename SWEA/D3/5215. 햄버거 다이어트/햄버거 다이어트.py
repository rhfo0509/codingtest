T=int(input())
def dfs(start,score,calorie):
  if calorie>L:
    return
  global result
  result=max(result,score)
  for i in range(start,N):
    if not visited[i]:
      S,C=data[i]
      visited[i]=True
      dfs(i+1,score+S,calorie+C)
      visited[i]=False
for tc in range(1,T+1):
  N,L=map(int,input().split())
  data=[tuple(map(int,input().split())) for _ in range(N)]
  visited=[False]*N
  result=0
  dfs(0,0,0)
  print(f'#{tc} {result}')
