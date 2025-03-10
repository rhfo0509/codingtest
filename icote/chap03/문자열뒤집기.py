s = input()

last = -1
c1 = 0
c2 = 0

for i in range(len(s)):
  if last != int(s[i]):
    if int(s[i]) == 0:
      c1 += 1
      last = 0
    else:
      c2 += 1
      last = 1

if c1 + c2 == 1:
  print(0)
else:
  print(min(c1, c2))