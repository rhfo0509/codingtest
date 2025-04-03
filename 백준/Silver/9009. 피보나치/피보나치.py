T=int(input())
for _ in range(T):
  n=int(input())
  f=[0,1]
  res=[]
  while f[-2]+f[-1]<=n:
    f.append(f[-2]+f[-1])
  for i in range(len(f)-1,0,-1):
    if n-f[i]>=0:
      res.append(f[i])
      n-=f[i]
    if n==0:
      break
  for i in range(len(res)-1,-1,-1):
    print(res[i], end=' ')
  print()