T=int(input())
for _ in range(T):
  N,M=map(int,input().split())
  A=sorted(map(int,input().split()))
  B=sorted(map(int,input().split()))
  cnt=0
  j=0
  for i in range(N):
    while j<M and A[i]>B[j]:
      j+=1
    cnt+=j
  print(cnt)