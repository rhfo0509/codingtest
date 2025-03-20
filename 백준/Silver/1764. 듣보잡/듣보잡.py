N, M = map(int, input().split())

s1 = set()
for _ in range(N):
  s1.add(input())
s2 = set()
for _ in range(M):
  s2.add(input())

result = sorted(list(s1.intersection(s2)))
print(len(result))
print('\n'.join(result))