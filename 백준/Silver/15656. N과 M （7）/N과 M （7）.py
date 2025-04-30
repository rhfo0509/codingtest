def nm7():
  if len(result)==M:
    print(*result)
    return
  for i in range(N):
    result.append(data[i])
    nm7()
    result.pop()
N,M=map(int,input().split())
data=sorted(map(int,input().split()))
result=[]
nm7()