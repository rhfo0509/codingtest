T = int(input())
for _ in range(T):
  S = input()
  cnt = 0
  score = 0
  for c in S:
    if c == 'X':
      cnt = 0
      continue
    cnt += 1
    score += cnt
  print(score)