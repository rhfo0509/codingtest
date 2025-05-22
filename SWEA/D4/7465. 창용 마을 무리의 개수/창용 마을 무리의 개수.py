T=int(input())
def find(x):
  if parent[x]!=x:
    parent[x]=find(parent[x])
  return parent[x]
def union(a,b):
  a=find(a)
  b=find(b)
  if a!=b:
    if a<b:
      parent[b]=a
    else:
      parent[a]=b
  
for tc in range(1,T+1):
  N,M=map(int,input().split())
  parent=[i for i in range(N+1)]
  result=set()
  for _ in range(M):
    a,b=map(int,input().split())
    union(a,b)
  for i in range(1,N+1):
    parent[i]=find(i)
    result.add(parent[i])
  print(f'#{tc} {len(result)}')
