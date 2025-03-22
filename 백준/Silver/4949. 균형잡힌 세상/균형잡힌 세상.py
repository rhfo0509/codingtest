while True:
  s = input()
  if s == '.':
    break

  stk = []
  for c in s:
    if c in '()[]':
      if stk and ((stk[-1] == '(' and c == ')') or (stk[-1] == '[' and c == ']')):
        stk.pop()
      else:
        stk.append(c)

  print('no') if stk else print('yes')