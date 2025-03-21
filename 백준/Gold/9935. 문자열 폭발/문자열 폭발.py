s = input()
bomb = input()

# stk = s.split(bomb)
# t = ''
# while stk:
#   t = stk.pop() + t

#   tt = ''.join(t.split(bomb))
#   if t == tt:
#     continue
#   stk.append(tt)
#   t = ''


# print('FRULA') if t == '' else print(t)

stk = []

for c in s:
  stk.append(c)

  if len(stk) >= len(bomb) and stk[-len(bomb):] == list(bomb):
    del stk[-len(bomb):]

print(''.join(stk)) if stk else print('FRULA')