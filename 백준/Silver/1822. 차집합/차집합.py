NA,NB=map(int,input().split())
A=list(map(int,input().split()))
A.sort()
B=list(map(int,input().split()))
B.sort()
cnt=0
res=[]
for i in A:
  start,end=0,NB-1
  while start<=end:
    mid=(start+end)//2
    if B[mid]==i:
      break
    elif B[mid]>i:
      end=mid-1
    else:
      start=mid+1
  if start>end:
    cnt+=1
    res.append(i)
print(cnt)
if res:
  print(*res)