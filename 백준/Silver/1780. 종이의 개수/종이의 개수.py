def f(n,x,y):
  s=set()
  for i in range(x,x+n):
    for j in range(y,y+n):
      s.add(li[i][j])
  if len(s)==1:
    v=s.pop()
    if v==-1:
      cnt[0]+=1
    elif v==0:
      cnt[1]+=1
    else:
      cnt[2]+=1
    return
  else:
    f(n//3,x,y)
    f(n//3,x,y+n//3)
    f(n//3,x,y+2*n//3)
    f(n//3,x+n//3,y)
    f(n//3,x+n//3,y+n//3)
    f(n//3,x+n//3,y+2*n//3)
    f(n//3,x+2*n//3,y)
    f(n//3,x+2*n//3,y+n//3)
    f(n//3,x+2*n//3,y+2*n//3)

N=int(input())
li=[list(map(int,input().split())) for _ in range(N)]
cnt=[0]*3
f(N,0,0)
print(cnt[0])
print(cnt[1])
print(cnt[2])