import sys
input = sys.stdin.readline
T=int(input())
for _ in range(T):
  N=int(input())
  A=list(map(int, input().split()))
  A.sort()
  r=[0]*N
  for i in range(N//2):
    r[i]=A[i*2]
    r[N-1-i]=A[i*2+1]
  if N%2==1:
    r[N//2]=A[-1]
  r.append(r[0])

  result=0
  for i in range(1, len(r)):
    result=max(result,abs(r[i-1]-r[i]))
  print(result)