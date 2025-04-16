N,C=map(int,input().split())
li=[]
D=dict()
for i in map(int,input().split()):
  if i not in li:
    li.append(i)
  D[i]=D.get(i,0)+1
li.sort(key=lambda x:(-D[x]))
for i in li:
  for _ in range(D[i]):
    print(i, end=' ')