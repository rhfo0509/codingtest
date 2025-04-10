import sys
input = sys.stdin.readline
N=int(input())
U=[]
for i in range(N):
  U.append(int(input()))
U.sort()

A=set()
for x in range(N):
  for y in range(x,N):
    A.add(U[x]+U[y])

i=-1
for k in range(N-1,-1,-1):
  for z in range(k+1):
    target=U[k]-U[z]
    if target in A:
      i=k
    if i!=-1:
      break
  if i!=-1:
    break

print(U[i])