N=int(input())
A=list(map(int,input().split()))
abs_value=int(2e8)
res=0
start,end=0,N-1
while start<end:
  if abs(A[start]+A[end])<=abs_value:
    abs_value=abs(A[start]+A[end])
    res=A[start]+A[end]
  if A[start]+A[end]<0:
    start+=1
  else:
    end-=1
print(res)