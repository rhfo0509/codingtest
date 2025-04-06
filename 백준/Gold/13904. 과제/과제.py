import sys
input = sys.stdin.readline

N = int(input())

li = []

for _ in range(N):
  li.append(tuple(map(int, input().split())))

li.sort(key= lambda x: (-x[0], -x[1]))

day = li[0][0] # 과제 수행 일수
score = 0 # 총 획득 점수
while day > 0:
  high = 0
  idx = None
  for i in range(len(li)):
    if li[i][0] < day:
      break
    else:
      if high < li[i][1]:
        high = li[i][1]
        idx = i
  day -= 1
  score += high
  if idx != None:
    del li[idx]

print(score)