N = int(input())

cnt = 0
for _ in range(N):
  s = input()
  alphabet = set(s[0])

  i = 1
  while i < len(s):
    if s[i - 1] != s[i] and s[i] in alphabet:
      break
    alphabet.add(s[i])
    i += 1
  
  if i == len(s):
    cnt += 1
print(cnt)