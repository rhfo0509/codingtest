N = int(input())
A = list(map(int,input().split()))
M = int(input())

A.sort()
for i in list(map(int,input().split())):
  start,end=0,N-1
  while start<=end:
    mid=(start+end)//2
    if A[mid]==i:
      break
    elif A[mid]<i:
      start=mid+1
    else:
      end=mid-1
  print(1) if start<=end else print(0)