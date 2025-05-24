import sys
input=sys.stdin.readline
N,M=map(int,input().split())
D=dict()
for i in range(N):
  pokemon=input().rstrip()
  D[pokemon]=i+1
  D[str(i+1)]=pokemon
for _ in range(M):
  print(D[input().rstrip()])