N = int(input())
NA = [0] * 1_000_000

for i in input().split():
  NA[int(i)] += 1

M = int(input())

for i in input().split():
  if NA[int(i)] == 1:
    print('yes', end=' ')
  else:
    print('no', end=' ')