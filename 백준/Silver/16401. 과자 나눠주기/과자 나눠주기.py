M,N=map(int,input().split())
L=list(map(int,input().split()))
start,end=1,int(1e9)
res=0
while start<=end:
  mid=(start+end)//2
  cnt=0
  for l in L:
    cnt+=l//mid
  if cnt>=M:
    res=mid
    start=mid+1
  else:
    end=mid-1
print(res)