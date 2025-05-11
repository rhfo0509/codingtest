T=int(input())
def dfs(start,target):
  global result
  if start==target:
    result=1
    return
  for end in graph[start]:
    dfs(end,target)
for tc in range(1,T+1):
  V,E=map(int,input().split())
  graph=[[] for _ in range(V+1)]
  for _ in range(E):
    start,end=map(int,input().split())
    graph[start].append(end)
  S,G=map(int,input().split())
  result=0
  dfs(S,G)
  print(f'#{tc} {result}')
