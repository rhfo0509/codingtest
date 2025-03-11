n = int(input())

h = list(map(int, input().split()))

max = 0

i = 0
while i < n:
  kill = 0
  for j in range(i+1, n):
    if h[i] < h[j]:
      break
    kill += 1
  if kill > max:
    max = kill
  i += kill + 1

print(max)