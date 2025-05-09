T=10
for tc in range(1, T + 1):
  # 원본 암호문의 길이
  N=int(input())
  # 원본 암호문
  data=list(map(int, input().split()))
  # 명령어의 개수
  M=int(input())
  # 명령어
  command=input().split()

  i=0
  while i<len(command):
    c = command[i]
    if c == 'I':
      x, y = int(command[i + 1]), int(command[i + 2])
      for j in range(y):
        data.insert(x + j, command[i + j + 3])
      i += 3 + y
    elif c == 'D':
      x, y = int(command[i + 1]), int(command[i + 2])
      for _ in range(y):
        data.remove(data[x])
      i += 3
    else:
      y = int(command[i + 1])
      for j in range(y):
        data.append(command[i + j + 2])
      i += 2 + y

  print(f'#{tc}', end=' ')
  for i in range(10):
    print(data[i], end=' ')
  print()