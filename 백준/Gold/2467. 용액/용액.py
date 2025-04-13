# 투-포인터
N=int(input())
li=list(map(int,input().split()))
li.sort()
start,end=0,N-1
min_sum=int(2e9)
res=None
while start<end:
  cur_sum=li[start]+li[end]
  if abs(cur_sum)<min_sum:
    min_sum=abs(cur_sum)
    res=[li[start],li[end]]
  if cur_sum>0:
    end-=1
  else:
    start+=1
print(*res)