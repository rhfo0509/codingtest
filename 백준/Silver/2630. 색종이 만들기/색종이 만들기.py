import sys
input=sys.stdin.readline
def f(n,x,y):
  global c0, c1
  s=set()
  for i in range(x,x+n):
    for j in range(y,y+n):
      s.add(li[i][j])
  if len(s)==1:
    v=s.pop()
    if v==0:
      c0+=1
    else:
      c1+=1
    return
  else:
    f(n//2,x,y)
    f(n//2,x,y+n//2)
    f(n//2,x+n//2,y)
    f(n//2,x+n//2,y+n//2)

N=int(input())
li=[list(map(int,input().split())) for _ in range(N)]
c0,c1=0,0
f(N,0,0)
print(c0)
print(c1)