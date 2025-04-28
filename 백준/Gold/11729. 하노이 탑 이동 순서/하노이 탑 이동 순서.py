path = []
def hanoi(start, end, n):
  if n == 1:
    path.append([start, end])
    return 1
  return hanoi(start, 6 - start - end, n - 1) + hanoi(start, end, 1) + hanoi(6 - start - end, end, n - 1)

N = int(input())
result = hanoi(1, 3, N)
print(result)
for p in path:
  print(*p)