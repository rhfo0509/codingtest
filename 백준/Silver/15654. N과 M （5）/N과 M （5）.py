def nm5():
  if len(result)==M:
    print(*result)
    return
  for i in range(N):
    if not used[i]:
      used[i]=True
      result.append(data[i])
      nm5()
      used[i]=False
      result.pop()
N,M=map(int,input().split())
data=sorted(map(int,input().split()))
used=[False]*N
result=[]
nm5()