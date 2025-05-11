T=int(input())
for tc in range(1,T+1):
  s=input()
  stk=[]
  for c in s:
    if not stk or stk[-1]!=c:
      stk.append(c)
    else:
      stk.pop()
  print(f'#{tc} {len(stk)}')
