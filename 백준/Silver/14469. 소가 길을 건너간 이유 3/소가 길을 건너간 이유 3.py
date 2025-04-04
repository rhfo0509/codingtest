N=int(input())
cows=[]
for _ in range(N):
  cows.append(list(map(int, input().split())))
cows.sort()
for i in range(N - 1):
  if sum(cows[i]) > cows[i + 1][0]:
    cows[i + 1][0] = sum(cows[i])
print(sum(cows[-1]))