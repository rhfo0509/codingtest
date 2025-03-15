n = int(input())

d = list(map(int, input().split()))
p = list(map(int, input().split()))

target = p[0]
cost = p[0] * d[0]

for i in range(n-2):
  if target > p[i+1]:
    target = p[i+1]
  cost += target * d[i+1]

print(cost)