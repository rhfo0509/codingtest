n = int(input())

a = input().split()

# 방향 벡터 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
move_types = {'U': 0, 'D': 1, 'L': 2, 'R': 3}

l = [1, 1]

for i in a:
  idx = move_types[i]
  
  nx = l[0] + dx[idx]
  ny = l[1] + dy[idx]

  if 1 <= nx <= n and 1 <= ny <= n:
    l[0], l[1] = nx, ny

print(l[0], l[1])