import sys
from collections import deque
input = sys.stdin.readline
N = int(input())
q = deque([])
for _ in range(N):
  cmd = input().split()
  if cmd[0] == 'push':
    q.append(cmd[1])
  elif cmd[0] == 'pop':
    print(-1 if not q else q.popleft())
  elif cmd[0] == 'size':
    print(len(q))
  elif cmd[0] == 'empty':
    print(1 if not q else 0)
  elif cmd[0] == 'front':
    print(-1 if not q else q[0])
  else:
    print(-1 if not q else q[-1])