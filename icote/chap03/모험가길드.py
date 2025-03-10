n = int(input())

a = list(map(int, input().split()))
a.sort()

group = 0
cnt = 0

for i in a:
  cnt += 1
  if cnt >= i:
    group += 1
    cnt = 0

print(group)

