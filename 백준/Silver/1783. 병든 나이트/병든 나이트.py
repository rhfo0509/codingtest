# N: 세로 길이, M: 가로 길이
N, M = map(int, input().split())

# 시작 위치는 방문 처리 
result = 1

# N = 1
if N == 1:
  pass
# N = 2
elif N == 2:
  result += min((M - 1) // 2, 3)
# N이 3 이상 (이제부터 N은 중요하지 않음)
else:
  if M == 1:
    pass
  elif M == 2:
    result += 1
  elif M == 3:
    result += 2
  elif M <= 6:
    result += 3
  else:
    result += (M - 7) + 4
print(result)  