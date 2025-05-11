T=int(input())
for tc in range(1,T+1):
  stk=[]
  result='error'
  for c in input().split():
    if c in '+-*/':
      if len(stk)<2:
        break
      if c=='+':
        stk.append(stk.pop()+stk.pop())
      elif c=='-':
        second=stk.pop()
        first=stk.pop()
        stk.append(first-second)
      elif c=='*':
        stk.append(stk.pop()*stk.pop())
      else:
        second=stk.pop()
        first=stk.pop()
        stk.append(first//second)
    elif c=='.':
      if len(stk)!=1:
        break
      result=stk.pop()
    else:
      stk.append(int(c))
  print(f'#{tc} {result}')
