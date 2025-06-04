import sys
input=sys.stdin.readline
N=int(input())
A=[]
for _ in range(N):
  A.append(int(input()))
A.sort()
print('\n'.join(map(str,A)))