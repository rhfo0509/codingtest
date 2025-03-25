from collections import Counter
N = int(input())
a = []
for _ in range(N):
  s = input()
  a.append(s[s.find('.')+1:])
c = Counter(a)
for name, count in sorted(c.items(), key= lambda x: x[0]):
  print(name, count)