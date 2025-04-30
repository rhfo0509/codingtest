def lotto(k):
  if len(result)==6:
    print(*result)
    return
  for i in range(k):
    if not used[i] and (not result or result[-1]<S[i]):
      used[i]=True
      result.append(S[i])
      lotto(k)
      used[i]=False
      result.pop()
while True:
  s=input()
  if s=='0':
    break
  data=list(map(int,s.split()))
  k=data[0]
  S=data[1:]
  used=[False]*k
  result=[]
  lotto(k)
  print()