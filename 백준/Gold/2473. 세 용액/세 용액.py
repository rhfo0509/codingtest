N=int(input())
li=list(map(int,input().split()))
li.sort()
min_sum=int(3e9)
res=None

# 이진 탐색: N^2 logN
for i in range(N-2):
  for j in range(i+1,N-1):
    start,end=j+1,N-1
    while start<end:
      mid=(start+end)//2
      if li[i]+li[j]+li[mid]<=0:
        start=mid+1
      else:
        end=mid-1
    tmp=[start]
    if start-1>j:
      tmp.append(start-1)
    if start+1<N:
      tmp.append(start+1)
    for k in tmp:
      if abs(li[i]+li[j]+li[k])<min_sum:
        min_sum=abs(li[i]+li[j]+li[k])
        res=[li[i],li[j],li[k]]
print(*res)