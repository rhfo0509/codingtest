def f(n,x,y):
  if n==1:
    return
  k=0
  for i in range(x+n//2, x+n):
    for j in range(y-n//2+k+1, y+n//2-k):
      li[i][j]=' '
    k+=1
  f(n//2,x,y)
  f(n//2,x+n//2,y-n//2)
  f(n//2,x+n//2,y+n//2)

N=int(input())
li=[[' ']*(2*N-1) for _ in range(N)]
for i in range(N):
  for j in range(N-1-i,N+i):
    li[i][j]='*'
f(N,0,N-1)
for i in range(N):
  print(''.join(li[i]))