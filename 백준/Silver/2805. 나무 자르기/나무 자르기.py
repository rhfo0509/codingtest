N,M=map(int,input().split())
L=list(map(int,input().split()))
L.sort(reverse=True)
start,end=0,int(1e9)
res=0
while start<=end:
  mid=(start+end)//2
  cnt=0
  for l in L:
    if l-mid<=0 or cnt>=M:
      break
    cnt+=l-mid
  if cnt>=M:
    res=mid
    start=mid+1
  else:
    end=mid-1
print(res)