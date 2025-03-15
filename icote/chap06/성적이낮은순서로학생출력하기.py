# 성적 -> 계수 정렬

n = int(input())

a = []
m = 0
for _ in range(n):
  k, v = input().split()
  a.append((k, int(v)))
  if m < int(v): m = int(v)

cnt = [0] * (m + 1)
names = [[] for _ in range(m + 1)]

for name, score in a:
  cnt[score] += 1
  names[score].append(name)

for i in range(len(cnt)):
  for name in names[i]:
    print(name)