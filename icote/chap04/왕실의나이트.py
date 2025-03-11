data = input()

r = int(data[1])
c = ord(data[0]) - ord('a') + 1

dx = [-2, -2, -1, -1, 1, 1, 2, 2]
dy = [-1, 1, -2, 2, -2, 2, -1, 1]

cnt = 0

for i in range(8):
  nx = r + dx[i]
  ny = c + dy[i]

  if 1 <= nx <= 8 and 1 <= ny <= 8:
    cnt += 1

print(cnt)