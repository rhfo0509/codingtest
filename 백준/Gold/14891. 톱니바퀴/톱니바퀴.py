gears = [list(map(int, input())) for _ in range(4)]

K = int(input())
methods = [list(map(int, input().split())) for _ in range(K)]

def turn(i, direction):
  # 시계 방향
  if direction == 1:
    gears[i] = [gears[i][-1]] + gears[i][:-1]
  # 반시계 방향
  else:
    gears[i] = gears[i][1:] + [gears[i][0]]

for method in methods:
  num, direction = method
  
  # 0-based
  num -= 1

  turns = []
  turns.append((num, direction))

  # num번 톱니바퀴 오른쪽에 위치한 톱니바퀴
  cur_direction = direction
  for i in range(num + 1, 4):
    if gears[i - 1][2] == gears[i][6]:
      break
    # 직전 톱니바퀴에 맞닿은 부분이 다른 경우
    else:
      cur_direction *= -1
      turns.append((i, cur_direction))

  # num번 톱니바퀴 왼쪽에 위치한 톱니바퀴
  cur_direction = direction
  for i in range(num - 1, -1, -1):
    if gears[i + 1][6] == gears[i][2]:
      break
    # 직전 톱니바퀴에 맞닿은 부분이 다른 경우
    else:
      cur_direction *= -1
      turns.append((i, cur_direction))

  # 모든 경우를 다 고려한 후 회전하기 (문제 잘 읽자.)
  for t in turns:
    i, direction = t
    turn(i, direction)

result = 0
if gears[0][0] == 1:
    result += 1
if gears[1][0] == 1:
    result += 2
if gears[2][0] == 1:
    result += 4
if gears[3][0] == 1:
    result += 8
print(result)