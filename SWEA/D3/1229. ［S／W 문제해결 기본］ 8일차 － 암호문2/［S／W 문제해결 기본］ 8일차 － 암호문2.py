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
    c, x, y = command[i], int(command[i + 1]), int(command[i + 2])
    if c == 'I':
      for j in range(y):
        data.insert(x + j, command[i + j + 3])
      i += 3 + y
    else:
      for _ in range(y):
        data.remove(data[x])
      i += 3

  print(f'#{tc}', end=' ')
  for i in range(10):
    print(data[i], end=' ')
  print()