import sys
input=sys.stdin.readline
T=int(input())
d=[0]*1_000_001
d[1],d[2],d[3]=1,2,4
for i in range(4,1_000_001):
  d[i]=(d[i-3]+d[i-2]+d[i-1])%1_000_000_009
for _ in range(T):
  N=int(input())
  print(d[N])