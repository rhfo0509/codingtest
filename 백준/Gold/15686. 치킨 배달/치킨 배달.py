from itertools import combinations
N, M = map(int, input().split())

data = [list(map(int, input().split())) for _ in range(N)]

houses = []
restaurants = []
for i in range(N):
  for j in range(N):
    if data[i][j] == 1:
      houses.append((i, j))
    elif data[i][j] == 2:
      restaurants.append((i, j))

# 도시의 "최소" 치킨 거리
result = int(1e9)

for comb in combinations(range(len(restaurants)), M):
  # 도시의 치킨 거리 구하기
  city_dist = 0

  for house in houses:
    hx, hy = house

    # 각 집의 치킨 거리 구하기
    home_dist = int(1e9)

    for pos in comb:
      rx, ry = restaurants[pos]
      home_dist = min(home_dist, abs(hx - rx) + abs(hy - ry))

    city_dist += home_dist

  result = min(result, city_dist)

print(result)