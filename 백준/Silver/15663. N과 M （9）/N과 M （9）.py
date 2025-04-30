def nm9():
  if len(result)==M:
    print(*result)
    return
  s=set()
  for i in range(N):
    if not used[i] and data[i] not in s:
      s.add(data[i])
      used[i]=True
      result.append(data[i])
      nm9()
      used[i]=False
      result.pop()

N,M=map(int,input().split())
data=sorted(map(int,input().split()))
used=[False]*N
result=[]
nm9()