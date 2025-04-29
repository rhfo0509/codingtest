def nm2():
  if len(li)==M:
    print(*li)
    return
  for i in range(1,N+1):
    if not used[i] and (not li or li[-1]<i):
      li.append(i)
      used[i]=True
      nm2()
      li.pop()
      used[i]=False
N,M=map(int,input().split())
used=[False]*(N+1)
li=[]
nm2()