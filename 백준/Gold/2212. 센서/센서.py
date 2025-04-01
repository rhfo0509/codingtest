N=int(input())
K=int(input())
pos=list(map(int,input().split()))
pos.sort()
diff=[]
res=pos[-1]-pos[0]
for i in range(1,len(pos)):
  diff.append(pos[i]-pos[i-1])
diff.sort()
for _ in range(min(K-1,N-1)):
  res-=diff.pop()
print(res)