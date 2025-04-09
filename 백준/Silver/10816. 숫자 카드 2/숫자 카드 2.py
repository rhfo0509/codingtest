from collections import Counter
N = int(input())
A = list(map(int,input().split()))
C = Counter(A)
M = int(input())
A.sort()
for i in list(map(int,input().split())):
  cnt=0
  start,end=0,N-1
  while start<=end:
    mid=(start+end)//2
    if A[mid]==i:
      break
    elif A[mid]<i:
      start=mid+1
    else:
      end=mid-1
  print(C[i], end=' ') if start<=end else print(0, end=' ')