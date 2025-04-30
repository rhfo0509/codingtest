def nm4():
  if len(result)==M:
    print(*result)
    return
  for i in range(1,N+1):
    if not result or result[-1]<=i:
      result.append(i)
      nm4()
      result.pop()
N,M=map(int,input().split())
result=[]
nm4()