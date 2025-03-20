T = int(input())

for _ in range(T):
  PS = input()
  stk = []
  for c in PS:
    if stk and stk[-1] == '(' and c == ')':
      stk.pop()
    else:
      stk.append(c)
  print('NO') if stk else print('YES')