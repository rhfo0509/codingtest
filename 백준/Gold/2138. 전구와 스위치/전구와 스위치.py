N = int(input())

# 0, 1번째 전구를 바꾸지 않는 경우
cur1 = list(map(int, input()))
# 0, 1번째 전구를 바꾸는 경우
cur2 = [1 - cur1[0], 1 - cur1[1]] + cur1[2:]
target = list(map(int, input()))

cnt1 = 0
cnt2 = 1

for i in range(1, N):
  if cur1[i - 1] != target[i - 1]:
    cur1[i - 1 : i + 2] = [1 - x for x in cur1[i - 1 : i + 2]]
    cnt1 += 1

  if cur2[i - 1] != target[i - 1]:
    cur2[i - 1 : i + 2] = [1 - x for x in cur2[i - 1 : i + 2]]
    cnt2 += 1

if cur1 != target and cur2 != target:
  print(-1)
elif cur1 != target:
  print(cnt2)
elif cur2 != target:
  print(cnt1)
else:
  print(cnt2) if cnt1 > cnt2 else print(cnt1)