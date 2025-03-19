T = int(input())
for _ in range(T):
  R, S = input().split()
  for c in S:
    print(c*int(R), end='')
  print()