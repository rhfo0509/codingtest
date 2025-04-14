N,M=map(int,input().split())
li=list(map(int,input().split()))
start,end=max(li),sum(li)
res=0
while start<=end:
  mid=(start+end)//2
  cnt=0
  sub_total=0
  for i in li:
    if sub_total+i>mid:
      cnt+=1
      sub_total=0
    sub_total+=i
  if sub_total>0:
    cnt+=1
  if cnt<=M:
    res=mid
    end=mid-1
  else:
    start=mid+1
print(res)