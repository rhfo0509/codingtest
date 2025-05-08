T = int(input())

for _ in range(T):
  N = int(input())
  scores = list(map(int, input().split()))
  count = dict()
  for score in scores:
    count[score] = count.get(score, 0) + 1
  result = sorted(list(count.items()), key=lambda x: (-x[1], -x[0]))[0][0]
  print(f'#{N} {result}')