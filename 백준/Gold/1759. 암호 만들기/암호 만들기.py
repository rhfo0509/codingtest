import itertools

L, C = map(int, input().split())

data = input().split()
data.sort()

a = [i for i in data if i in 'aeiou']
b = [i for i in data if i not in 'aeiou']

result = []
for m in range(1, L - 1):
  pa = list(itertools.combinations(a, m))
  pb = list(itertools.combinations(b, L - m))

  # 투 포인터
  for aa in pa:
    for bb in pb:
      result.append(''.join(sorted(list(aa + bb))))

result.sort()
print('\n'.join(result))