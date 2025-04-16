N=int(input())
cnt=0
for _ in range(N):
  stk=[]
  for c in input():
    if stk and stk[-1]==c:
      stk.pop()
    else:
      stk.append(c)
  if not stk:
    cnt+=1
print(cnt)
