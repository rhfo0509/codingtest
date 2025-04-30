def nm10():
  if len(result)==M:
    print(*result)
    return
  # depth별로 같은 수가 선택되지 않도록 prev 변수로 관리
  prev=-1
  for i in range(N):
    if not used[i] and prev!=data[i] and (not result or result[-1]<=data[i]):
      prev=data[i]
      used[i]=True
      result.append(data[i])
      nm10()
      used[i]=False
      result.pop()

N,M=map(int,input().split())
data=sorted(map(int,input().split()))
used=[False]*N
result=[]
nm10()