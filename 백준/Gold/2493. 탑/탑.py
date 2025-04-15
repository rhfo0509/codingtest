N=int(input())
res=[0]*N

tops=[]
for i,top in enumerate(map(int,input().split())):
  while tops and tops[-1][1]<top:
    tops.pop()
  if tops:
    res[i]=tops[-1][0]
  else:
    res[i]=0
  tops.append((i+1, top))
print(*res)