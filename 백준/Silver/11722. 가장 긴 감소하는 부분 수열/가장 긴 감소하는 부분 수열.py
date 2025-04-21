N=int(input())
A=[0]+list(map(int,input().split()))

li=[0]*(N+1)
res=li[1]=1

for i in range(2,N+1):
  max_len=1
  for j in range(1,i):
    if A[j]>A[i] and li[j]+1>max_len:
      max_len=li[j]+1
  li[i]=max_len
  res=max(res,max_len)

print(res)