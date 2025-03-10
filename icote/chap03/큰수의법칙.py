
n, m, k = map(int, input().split())

arr = list(map(int, input().split()))

arr.sort()

first = arr[-1]
second = arr[-2]

sum = 0
cnt = k

while m > 0:

  if cnt > 0:
    sum += first
    m -= 1
    cnt -= 1
  else:
    sum += second
    m -= 1
    cnt = k

print(sum)
  