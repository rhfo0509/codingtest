# [1, 1, 2, 3, 6, 7, 30]
N = int(input())
weight = list(map(int, input().split()))
weight.sort()

target = 1 # 현재 만들 수 있는 범위는 1부터 target-1까지
for w in weight:
  # 만들 수 있는 범위에 w를 더할때 target을 만들 수 없는 경우
  if w > target:
    break
  else:
    target += w
print(target)