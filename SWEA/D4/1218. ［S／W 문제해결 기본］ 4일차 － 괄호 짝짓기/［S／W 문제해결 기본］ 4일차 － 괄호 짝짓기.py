T=10
for tc in range(1, T+1):
  N=int(input())
  s=input()
  li=[]
  result=1
  for c in s:
    if not li:
      if c not in '([{<':
        result=0
        break
      else:
        li.append(c)
    else:
      if c in '([{<':
        li.append(c)
      else:
        if (li[-1]=='(' and c==')') or (li[-1]=='[' and c==']') or (li[-1]=='{' and c=='}') or (li[-1]=='<' and c=='>'):
          li.pop()
        else:
          result=0
          break
  if li:
    result=0
  print(f'#{tc} {result}')