import sys
from collections import Counter
input=sys.stdin.readline
N=int(input())
A=[]
for _ in range(N):
  A.append(int(input()))
A.sort()
C=Counter(A).most_common()
print(round(sum(A)/len(A)))
print(A[N//2])
print(C[1][0] if N!=1 and C[0][1]==C[1][1] else C[0][0])
print(max(A)-min(A))