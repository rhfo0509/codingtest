from collections import deque
T=int(input())
for _ in range(T):
  N,M=map(int,input().split())
  A=list(map(int,input().split()))
  B=deque([])
  for i in range(N):
    B.append((i,A[i]))
  A.sort()
  result=[]
  while B:
    if A[-1]==B[0][1]:
      A.pop()
      result.append(B.popleft()[0])
    else:
      B.append(B.popleft())
  print(result.index(M)+1)