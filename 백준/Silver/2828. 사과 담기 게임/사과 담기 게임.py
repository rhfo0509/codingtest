n, m = map(int, input().split())

j = int(input())

a = []

for i in range(j):
  a.append(int(input()))

dis = 0   # 움직인 거리
cur = 1   # 현재 위치

for i in range(j):
  if cur <= a[i] <= cur + m - 1:
    continue
  
  if cur > a[i]:
    dis += cur - a[i]
    cur = a[i]
  else:
    dis += a[i] - (cur + m - 1)
    cur = a[i] - (m - 1)

print(dis)