N,M=map(int,input().split())
D=dict()
for _ in range(N):
  site,pw=input().split()
  D[site]=pw
for _ in range(M):
  print(D[input()])