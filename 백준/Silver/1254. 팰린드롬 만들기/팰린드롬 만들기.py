s = input()

i = 0
while i < len(s):
  t = s[i:]
  if t[0 : len(t) // 2] == t[len(t) // 2 + 1 if len(t) % 2 == 1 else len(t) // 2 : len(t)][::-1]:
    break
  i += 1
print(len(s) + i)