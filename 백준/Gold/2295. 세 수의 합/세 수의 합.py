import sys
input = sys.stdin.readline
N=int(input())
U=[]
for i in range(N):
  U.append(int(input()))
U.sort()

A=[]
for x in range(N):
  for y in range(x,N):
    A.append(U[x]+U[y])
A.sort()

i=0
for z in range(N):
  for k in range(z,N):
    target=U[k]-U[z]
    start,end=0,len(A)-1
    while start<=end:
      mid=(start+end)//2
      if A[mid]==target:
        break
      elif A[mid]<target:
        start=mid+1
      else:
        end=mid-1
    if start<=end:
      i=max(i,k)

print(U[i])