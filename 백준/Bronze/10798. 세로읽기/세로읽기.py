a = [['']*5 for _ in range(15)]

for i in range(5):
  s = input()
  for j in range(len(s)):
    a[j][i] = s[j]

for i in range(15):
  print(''.join(a[i]), end='')