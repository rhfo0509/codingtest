from collections import deque
T=10
for _ in range(T):
  N, M = map(int, input().split())
  li = list(map(int, input().split()))

  data1 = [-1] * 100
  data2 = [-1] * 100

  for i in range(0, M * 2, 2):
    start, end = li[i], li[i + 1]
    if data1[start] == -1:
      data1[start] = end
    else:
      data2[start] = end

  result = 0

  # dfs
  def dfs(node):
    global result
    if node == 99:
      result = 1
      return
    if data1[node] == -1 and data2[node] == -1:
      return
    if data1[node] != -1:
      dfs(data1[node])
    if data2[node] != -1:
      dfs(data2[node])

  dfs(0)

  print(f'#{N} {result}')
