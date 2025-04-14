N=int(input())
A=list(map(int,input().split()))
A.sort()
res=0
for i in range(N):
  start,end=0,N-1
  while start<end:
    if start==i:
      start+=1
      continue
    if end==i:
      end-=1
      continue
    if A[start]+A[end]==A[i]:
      res+=1
      break
    elif A[start]+A[end]>A[i]:
      end-=1
    else:
      start+=1
print(res)