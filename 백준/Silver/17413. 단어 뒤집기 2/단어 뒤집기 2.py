s=input()
stk=[]
r=''
i=0
while i<len(s):
  if s[i] == '<':
    while len(stk) != 0:
      r += stk.pop()
    while s[i] != '>':
      r += s[i]
      i += 1
    r += '>'
    i += 1
  elif s[i] == ' ':
    while len(stk) != 0:
      r += stk.pop()
    r += ' '
    i += 1
  else:
    stk.append(s[i])
    i += 1
while len(stk) != 0:
  r += stk.pop()
print(r)