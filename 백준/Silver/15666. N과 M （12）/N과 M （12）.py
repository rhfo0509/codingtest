def nm12():
  if len(result)==M:
    print(*result)
    return
  prev=-1
  for i in range(N):
    if prev!=data[i] and (not result or result[-1]<=data[i]):
      prev=data[i]
      result.append(data[i])
      nm12()
      result.pop()

N,M=map(int,input().split())
data=sorted(map(int,input().split()))
result=[]
nm12()