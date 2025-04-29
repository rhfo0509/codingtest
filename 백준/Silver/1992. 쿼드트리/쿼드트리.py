def f(n,x,y):
  global res
  s=set()
  for i in range(x,x+n):
    for j in range(y,y+n):
      s.add(li[i][j])
  if len(s)==1:
    v=s.pop()
    if v==0:
      res+='0'
    else:
      res+='1'
    return
  else:
    res+='('
    f(n//2,x,y)
    f(n//2,x,y+n//2)
    f(n//2,x+n//2,y)
    f(n//2,x+n//2,y+n//2)
    res+=')'

N=int(input())
li=[list(map(int,input())) for _ in range(N)]
res=''
f(N,0,0)
print(res)