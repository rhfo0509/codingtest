N = int(input())
M = int(input())
S = input()
P = 'IO' * N + 'I'

result = 0
i = 0
count = 0
for C in S:
  if C == P[i]:
    i += 1
    count += 1
    if count == len(P):
      result += 1
      count -= 2
      i = 1
  else:
    if C == 'I':
      count = 1
      i = 1
    else:
      count = 0
      i = 0
print(result)