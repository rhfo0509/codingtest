def f(n,x,y):
  if n==1:
    return
  else:
    for i in range(x+n//3,x+2*n//3):
      for j in range(y+n//3,y+2*n//3):
        li[i][j]=' '
    f(n//3,x,y)
    f(n//3,x,y+n//3)
    f(n//3,x,y+2*n//3)
    f(n//3,x+n//3,y)
    # f(n//3,x+n//3,y+n//3)
    f(n//3,x+n//3,y+2*n//3)
    f(n//3,x+2*n//3,y)
    f(n//3,x+2*n//3,y+n//3)
    f(n//3,x+2*n//3,y+2*n//3)

N=int(input())
li=[['*']*N for _ in range(N)]
f(N,0,0)
for i in range(N):
  for j in range(N):
    print(li[i][j],end='')
  print()