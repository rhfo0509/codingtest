N, M = map(int, input().split())
used = [False] * (N + 1)
result = []

def nm1():
  if len(result) == M:
    print(*result)
    return
  for i in range(1, N + 1):
    if not used[i]:
      result.append(i)
      used[i] = True
      nm1()
      result.pop()
      used[i] = False

nm1()