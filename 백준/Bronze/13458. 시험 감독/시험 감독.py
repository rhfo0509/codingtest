N=int(input())
A=list(map(int,input().split()))
B,C=map(int,input().split())
cnt=0
for i in range(N):
  # 총감독관은 1명
  A[i]-=B
  cnt+=1
  # 부감독관은 여러명
  if A[i]>0:
    cnt+=(A[i]//C)
    if A[i]%C>0:
      cnt+=1
print(cnt)