S = list(map(int, input()))

c0 = S.count(0) // 2
c1 = S.count(1) // 2

i = len(S) - 1
while c0:
  if S[i] == 0:
    del S[i]
    c0 -= 1
  i -= 1

j = 0
while c1:
  if S[j] == 1:
    del S[j]
    c1 -= 1
    j -= 1
  j += 1

print(''.join(map(str, S)))