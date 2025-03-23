s=input()
r=''
for c in s:
  if not c.isalpha():
    r += c
    continue
  t = ord(c) + 13
  if (ord('a') <= ord(c) <= ord('z') and t > ord('z')) or (ord('A') <= ord(c) <= ord('Z') and t > ord('Z')):
    t -= 26
  r += chr(t)
print(r)