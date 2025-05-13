T = int(input())

for tc in range(1, T + 1):
  N, M, L = map(int, input().split())
  data = list(map(int, input().split()))

  try:
    for _ in range(M):
      cmd = input().split()

      if cmd[0] == 'I':
        data.insert(int(cmd[1]), int(cmd[2]))
      elif cmd[0] == 'D':
        data.pop(int(cmd[1]))
      else:
        data[int(cmd[1])] = int(cmd[2])

    result = data[L]
    print(f'#{tc} {result}')
  
  except IndexError:
    print(f'#{tc} {-1}')
