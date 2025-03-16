T = int(input())

res = []
for i in range(T):
  N = int(input())
  SP = list(map(int, input().split()))

  max_number = 0
  gain = 0

  for j in range(N-1, -1, -1):
    if SP[j] > max_number:
      max_number = SP[j]
    else:
      gain += max_number - SP[j]
    
  res.append(gain)

for i in range(len(res)):
  print(res[i])