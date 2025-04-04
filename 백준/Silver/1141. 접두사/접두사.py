# 접두사X 집합: 집합의 어떤 한 단어가, 다른 단어의 접두어가 되지 않는 집합

# 단어의 개수가 50 이하이니, 이중 반복문 사용 가능
N = int(input())
li = []

for _ in range(N):
  li.append(input())
li.sort(key = lambda x: len(x))

result = N

for i in range(N - 1):
  for j in range(i + 1, N):
    if li[j].startswith(li[i]):
      result -= 1
      break

print(result)