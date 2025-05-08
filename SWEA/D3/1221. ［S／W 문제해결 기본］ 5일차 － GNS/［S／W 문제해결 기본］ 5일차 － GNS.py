T=int(input())
D = ['ZRO', 'ONE', 'TWO', 'THR', 'FOR', 'FIV', 'SIX', 'SVN', 'EGT', 'NIN']
for _ in range(T):
  tc, N = input().split()
  data = input().split()

  for i in range(int(N)):
    data[i] = D.index(data[i])

  data.sort()

  for i in range(int(N)):
    data[i] = D[data[i]]

  print(tc)
  print(*data)