def nm8():
  if len(result)==M:
    print(*result)
    return
  for i in range(N):
    if not result or result[-1]<=data[i]:
      result.append(data[i])
      nm8()
      result.pop()
N,M=map(int,input().split())
data=sorted(map(int,input().split()))
result=[]
nm8()