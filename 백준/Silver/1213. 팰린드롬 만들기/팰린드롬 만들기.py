s = list(input())
s.sort()
i = 0
r = [''] * 50

a = []
for c in s:
  if a and c == a[-1]:
    a.pop()
    r[i] = r[50-i-1] = c
    i += 1
  else:
    a.append(c)

if len(a) >= 2:
  print("I'm Sorry Hansoo")
else:
  if a:
    r[i] = a[0]
  print(''.join(r))