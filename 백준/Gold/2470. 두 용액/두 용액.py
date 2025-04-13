# 이진-탐색
N=int(input())
li=list(map(int,input().split()))
li.sort()
min_sum=int(2e9)
res=None
for i in range(N-1):
  start,end=i+1,N-1
  while start<end:
    mid=(start+end)//2
    if li[i]+li[mid]<=0:
      start=mid+1
    else:
      end=mid-1
  # start==end
  tmp=[start]
  if start-1>i:
    tmp.append(start-1)
  if start+1<N:
    tmp.append(start+1)
  for j in tmp:
    if abs(li[i]+li[j])<min_sum:
      min_sum=abs(li[i]+li[j])
      res=[li[i],li[j]]
print(*res)