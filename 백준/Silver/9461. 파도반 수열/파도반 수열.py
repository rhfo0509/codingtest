T=int(input())
d=[0]*101
d[1],d[2],d[3]=1,1,1
for i in range(4,101):
  d[i]=d[i-3]+d[i-2]
for _ in range(T):
  N=int(input())
  print(d[N])