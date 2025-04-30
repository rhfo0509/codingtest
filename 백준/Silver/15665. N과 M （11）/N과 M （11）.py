def nm11():
  if len(result)==M:
    print(*result)
    return
  prev=-1
  for i in range(N):
    if prev!=data[i]:
      prev=data[i]
      result.append(data[i])
      nm11()
      result.pop()

N,M=map(int,input().split())
data=sorted(map(int,input().split()))
result=[]
nm11()