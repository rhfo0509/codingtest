import collections
S = input().upper()
C = collections.Counter(S).most_common()
if len(C) == 1:
  print(C[0][0])
elif C[0][1] == C[1][1]:
  print('?')
else:
  print(C[0][0])