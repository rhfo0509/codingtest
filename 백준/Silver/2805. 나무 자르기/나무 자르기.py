N,M=map(int,input().split())
L=list(map(int,input().split()))
start,end=0,max(L)
res=0
while start<=end:
  mid=(start+end)//2
  cnt=sum(l-mid for l in L if l>mid)
  if cnt>=M:
    res=mid
    start=mid+1
  else:
    end=mid-1
print(res)