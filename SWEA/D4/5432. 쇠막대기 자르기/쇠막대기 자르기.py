T = int(input())

for tc in range(1, T + 1):
  s = input()
  stk = []
  result = 0
  i = 0
  while i < len(s):
    if s[i] == '(' and s[i + 1] == ')':
      result += len(stk)
      i += 2
      continue
    if not stk or s[i] == '(':
      stk.append('(')
    else:
      stk.pop()
      result += 1
    i += 1
  print(f'#{tc} {result}')