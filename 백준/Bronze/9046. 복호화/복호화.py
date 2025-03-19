import collections
T = int(input())

freq = ''
for _ in range(T):
  S = ''.join(input().split())
  C = collections.Counter(S).most_common()
  if len(C) == 1:
    freq += C[0][0]
    continue
  if C[0][1] == C[1][1]:
    freq += '?'
  else:
    freq += C[0][0]

for c in freq:
  print(c)