N,M=map(int,input().split())
truth=set(list(map(int,input().split()))[1:])
cur=truth
party=[]
for _ in range(M):
  party.append(set(list(map(int,input().split()))[1:]))

while True:
  for members in party:
    for num in members:
      if num in truth:
        truth=truth.union(members)
        break
  if cur==truth:
    break
  cur=truth

result=0
for members in party:
  flag=True
  for num in members:
    if num in truth:
      flag=False
      break
  if flag:
    result+=1
print(result)