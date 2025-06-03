from collections import deque
N, K = map(int, input().split())
A = deque(map(int, input().split()))
used = deque([False] * N)

level = 1

while True:

  # 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
  A.appendleft(A.pop())
  used.appendleft(used.pop())
  # 언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내린다.
  used[-1] = False

  # 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다
  for i in range(N - 2, -1, -1):
    if used[i] and not used[i + 1] and A[i + 1] != 0:
      used[i] = False
      used[i + 1] = True
      A[i + 1] -= 1
  # 언제든지 로봇이 내리는 위치에 도달하면 그 즉시 내린다.
  used[-1] = False

  # 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
  if A[0] != 0:
    used[0] = True
    A[0] -= 1

  # 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다.
  if A.count(0) >= K:
    break

  level += 1

print(level)