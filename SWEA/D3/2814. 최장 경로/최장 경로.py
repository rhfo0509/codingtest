T=int(input())

def dfs(depth,idx):
  global result
  result=max(result,depth)
  for j in graph[idx]:
    if not visited[j]:
      visited[j]=True
      dfs(depth+1,j)
      visited[j]=False

for tc in range(1,T+1):
  N,M=map(int,input().split())
  graph=[[] for _ in range(N)]
  for _ in range(M):
    x,y=map(int,input().split())
    graph[x-1].append(y-1)
    graph[y-1].append(x-1)
  result=1
  visited=[False]*N
  for i in range(N):
    visited[i]=True
    dfs(1,i)
    visited[i]=False
  print(f'#{tc} {result}')