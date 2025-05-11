T=int(input())
for tc in range(1,T+1):
  s=input()
  stk=[]
  res=1
  for c in s:
    if c in '{(':
      stk.append(c)
    elif c in '})':
      if not stk:
        res=0
        break
      if (c=='}' and stk[-1]=='(') or (c==')' and stk[-1]=='{'):
        res=0
        break
      stk.pop()
    else:
      continue
  if stk:
    res=0
  print(f'#{tc} {res}')
