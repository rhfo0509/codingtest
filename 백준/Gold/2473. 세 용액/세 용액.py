N=int(input())
li=list(map(int,input().split()))
li.sort()
min_sum=int(3e9)
res=None

# 투 포인터: N^2
for i in range(N-2):
  j,k=i+1,N-1
  while j<k:
    cur_sum=li[i]+li[j]+li[k]
    if abs(cur_sum)<min_sum:
      min_sum=abs(cur_sum)
      res=[li[i],li[j],li[k]]
    if cur_sum>0:
      k-=1
    else:
      j+=1
print(*res)