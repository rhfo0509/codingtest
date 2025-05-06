N = int(input())
A = list(map(int, input().split()))

li = list(map(int, input().split()))
op = ['+'] * li[0] + ['-'] * li[1] + ['*'] * li[2] + ['/'] * li[3]

max_value = -int(1e9)
min_value = int(1e9)
result = []
used = [False] * (N - 1)

def backtracking():
  global max_value, min_value

  if len(result) == N - 1:
    # 계산하는 부분
    tmp = A[0]
    for i in range(N - 1):
      if result[i] == '+':
        tmp += A[i + 1]
      elif result[i] == '-':
        tmp -= A[i + 1]
      elif result[i] == '*':
        tmp *= A[i + 1]
      else:
        tmp = int(tmp / A[i + 1])


    max_value = max(max_value, tmp)
    min_value = min(min_value, tmp)
    return

  prev = None
  for i in range(N - 1):
    if not used[i] and prev != op[i]:
      prev = op[i]
      used[i] = True
      result.append(op[i])
      backtracking()
      used[i] = False
      result.pop()

backtracking()
print(max_value)
print(min_value)