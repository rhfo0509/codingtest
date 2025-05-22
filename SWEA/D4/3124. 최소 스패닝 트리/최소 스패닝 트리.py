T=int(input())
def find(x):
  if parent[x]!=x:
    parent[x]=find(parent[x])
  return parent[x]
def union(a,b):
  if a<b:
    parent[b]=a
  else:
    parent[a]=b
for tc in range(1,T+1):
  V,E=map(int,input().split())
  parent=[i for i in range(V+1)]
  graph=[]
  for _ in range(E):
    A,B,C=map(int,input().split())
    graph.append((C,A,B))
  graph.sort()
  count=0
  cost=0
  for c,a,b in graph:
    if find(a)==find(b):
      continue
    union(find(a),find(b))
    count+=1
    cost+=c
    if count==V-1:
      break
  print(f'#{tc} {cost}')
