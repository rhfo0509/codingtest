import sys
input=sys.stdin.readline
N,M=map(int,input().split())
li=[]
for _ in range(N):
  li.append(int(input()))
li.sort()
res=0
start,end=0,max(li)*M
while start<=end:
  mid=(start+end)//2
  cnt=0
  for i in li:
    cnt+=mid//i
    if cnt>=M:
      break
  if cnt>=M:
    res=mid
    end=mid-1
  else:
    start=mid+1
print(res)