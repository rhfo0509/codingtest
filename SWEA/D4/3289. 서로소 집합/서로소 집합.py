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
  n,m=map(int,input().split())
  parent=[i for i in range(n+1)]
  result=''
  for _ in range(m):
    cmd,a,b=map(int,input().split())
    if cmd==0:
      union(a,b)
    else:
      if find(a)==find(b):
        result+='1'
      else:
        result+='0'
  print(f'#{tc} {result}')