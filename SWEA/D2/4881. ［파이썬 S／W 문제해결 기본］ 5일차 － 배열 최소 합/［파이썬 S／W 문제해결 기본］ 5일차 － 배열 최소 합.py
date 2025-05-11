T=int(input())
def backtracking(i,total):
  global result
  if total>=result:
    return
  if i==N:
    result=min(result,total)
    return
  for j in range(N):
    if not visited[j]:
      visited[j]=True
      backtracking(i+1,total+data[i][j])
      visited[j]=False
    
for tc in range(1,T+1):
  N=int(input())
  data=[list(map(int,input().split())) for _ in range(N)]
  visited=[False]*N
  result=int(1e9)
  backtracking(0,0)
  print(f'#{tc} {result}')
