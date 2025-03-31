N, L = map(int, input().split())
spot = list(map(int, input().split()))

spot.sort()

result = 0
start = end = 0
for i in range(len(spot)):
  if i == 0:
    start = spot[i]
  else:
    end = spot[i]
    if end - start > L - 1:
      start = spot[i]
      result += 1

if end - start <= L - 1:
  result += 1
print(result)