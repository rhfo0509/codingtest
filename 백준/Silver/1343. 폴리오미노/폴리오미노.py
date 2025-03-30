s = input()
cnt = 0
res = ''

def polyomino():
  # 2로 나누어 떨어지지 않으면 -1 출력
  if cnt % 2 != 0:
    print(-1)
    exit()
  # 아니라면 A와 B 채우기
  return 'AAAA' * (cnt // 4) + 'BB' * (0 if cnt == (cnt // 4) * 4 else 1)

for i in range(len(s)):
  if s[i] == 'X':
    cnt += 1
  # . 이 맨 처음에 나타나지 않고, 바로 앞에 X가 있는 경우
  elif i != 0 and s[i - 1] == 'X':
    r = polyomino()
    res += r + '.'
    cnt = 0
  else:
    res += '.'

res += polyomino()
print(res)