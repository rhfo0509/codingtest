X,Y=map(int,input().split())
per=Y*100//X
start,end=0,int(1e9)
res=-1
while start<=end:
  mid=(start+end)//2
  tx=X+mid
  ty=Y+mid
  if ty*100//tx!=per:
    res=mid
    end=mid-1
  else:
    start=mid+1
print(res)