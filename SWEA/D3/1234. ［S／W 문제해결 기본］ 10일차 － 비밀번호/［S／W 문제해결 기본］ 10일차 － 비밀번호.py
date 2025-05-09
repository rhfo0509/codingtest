T=10
for tc in range(1, T + 1):
  N, s = input().split()
  N = int(N)
  data = list(s)

  while True:
    flag = False
    for i in range(len(data) - 1):
      if data[i] == data[i + 1]:
        flag = True
        data.pop(i + 1)
        data.pop(i)
        break
    if flag == False:
      break

  print(f'#{tc}', end=' ')
  print(''.join(data))
