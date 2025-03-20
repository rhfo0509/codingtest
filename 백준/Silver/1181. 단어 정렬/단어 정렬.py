N = int(input())
s = set()
for _ in range(N):
  s.add(input())
a = list(s)
a.sort(key= lambda x: (len(x), x))
print('\n'.join(a))