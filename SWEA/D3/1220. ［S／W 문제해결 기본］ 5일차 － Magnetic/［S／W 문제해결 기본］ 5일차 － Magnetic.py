T=10
for tc in range(1, T + 1):
  N = int(input())
  table = [''] * 100
  for _ in range(100):
    data = input().split()
    for i in range(100):
      if data[i] != '0':
        table[i] += data[i]
  
  result = 0
  for data in table:
    for i in range(1, len(data)):
      if data[i - 1] == '1' and data[i] == '2':
        result += 1

  print(f'#{tc} {result}')