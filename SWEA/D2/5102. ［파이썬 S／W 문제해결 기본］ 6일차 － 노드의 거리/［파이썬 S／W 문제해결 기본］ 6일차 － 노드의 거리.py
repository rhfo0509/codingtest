from collections import deque
T=int(input())
for tc in range(1,T+1):
  V,E=map(int,input().split())
  graph=[[] for _ in range(V+1)]
  for _ in range(E):
    start,end=map(int,input().split())
    graph[start].append(end)
    graph[end].append(start)
  visited=[0]*(V+1)
  S,G=map(int,input().split())
  q=deque([(S)])
  result=0
  while q:
    start=q.popleft()
    if start==G:
      result=visited[G]
      break
    for end in graph[start]:
      if visited[end]==0:
        visited[end]=visited[start]+1
        q.append(end)
  print(f'#{tc} {result}')

