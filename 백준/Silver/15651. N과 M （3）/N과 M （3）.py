def nm3():
  if len(result)==M:
    print(*result)
    return
  for i in range(1,N+1):
    result.append(i)
    nm3()
    result.pop()
N,M=map(int,input().split())
result=[]
nm3()