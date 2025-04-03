N = int(input())
s = input()

color = None
cnt_B = 0
cnt_R = 0

for c in s:
  if c != color:
    if c == 'B':
      cnt_B += 1
    else:
      cnt_R += 1
    color = c

print(min(cnt_B, cnt_R) + 1)