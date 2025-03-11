n = int(input())
change = 1000 - n

yen = [500, 100, 50, 10, 5, 1]
cnt = 0

for i in yen:
  cnt += change // i
  change %= i

print(cnt)